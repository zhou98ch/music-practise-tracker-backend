package com.example.server.service;

import com.example.pojo.entity.PracticeTimeRecord;
import com.example.server.mapper.PractiseTimeRecordMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final PractiseTimeRecordMapper recordMapper;

    public PracticeTimeRecord createRecord(PracticeTimeRecord record) {
        PracticeTimeRecord exsitingRecord = recordMapper.findByUniqueRecord(record.getUserId(), record.getMusicId(), record.getBpm(), record.getDate());
        if(exsitingRecord!= null){
            recordMapper.updateDuration(exsitingRecord.getId(), record.getDuration(), record.getUpdatedAt());
        }
        else{
            recordMapper.insert(record);
        }
        return record;
    }
    @Transactional
    public BatchResult sync(List<PracticeTimeRecord> records) {
        if (records == null || records.isEmpty()) {
            return new BatchResult(0, 0);
        }

        // try batch insert first
        try {
            int inserted = recordMapper.insertBatch(records);
            int duplicated = records.size() - inserted;
            return new BatchResult(inserted, duplicated);
        } catch (org.springframework.dao.DuplicateKeyException ex) {
            // in h2 batch insert may fail as a whole when a unique constraint is violated
            // degrade to insert one by one, to keep synchronization idempotent.
            int inserted = 0;
            int duplicated = 0;
            for (PracticeTimeRecord r : records) {
                try {
                    recordMapper.insert(r);
                    inserted++;
                } catch (org.springframework.dao.DuplicateKeyException e) { //TODO: put into global handler
                    duplicated++;
                }
            }
            return new BatchResult(inserted, duplicated);
        }
    }

    public record BatchResult(int inserted, int duplicated) {}
}

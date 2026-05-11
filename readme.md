# Backend Development Log

This phase focused on evaluating the current backend status and aligning it with the frontend recording timeline prototype. The backend already contains several foundational modules, including user management, authentication, song and category management, practice record handling, and an initial recording-related structure. However, the backend is not yet complete enough to fully support the new timeline-based recording workflow implemented on the frontend.

## Completed

- [x] Set up the basic Spring Boot backend structure.
- [x] Implemented user registration and login flow.
- [x] Added JWT token generation and basic authentication support.
- [x] Implemented foundational CRUD support for songs.
- [x] Implemented foundational CRUD support for categories.
- [x] Added practice time record storage and batch synchronization logic.
- [x] Created initial database tables for `track` and `lane`.
- [x] Added a basic API endpoint for lane creation.
- [x] Added a file upload controller scaffold.
- [x] Added global exception handling.
- [x] Configured MyBatis mapper support and base persistence structure.

## In Progress / Not Yet Completed

- [] Build a complete backend domain model for the recording timeline workflow.
- [] Create a dedicated `Take` entity for recorded audio clips.
- [] Add database table(s) for `take` persistence.
- [] Add DTOs, mappers, services, and controllers for `take`.
- [] Support saving recorded audio metadata aligned with the video timeline.
- [] Support loading timeline data for a song, including tracks, lanes, and takes.
- [] Complete track management APIs.
- [] Complete lane management APIs beyond simple creation.
- [] Persist uploaded audio files in a usable storage location instead of placeholder paths.
- [] Connect uploaded file URLs with saved take records.
- [] Add user ownership checks for recording-related resources.
- [] Extend JWT protection to song, track, lane, and take APIs.
- [] Improve backend configuration so it is ready for real frontend integration.
- [] Add tests for the new recording-related APIs and persistence logic.
## Next step important migrations
- Apply Domain-Driven-Design methods (see next chapter)
- migrate to state-of-art framework/tool （some in this project are too old ）
# Domain-Driven-Design migration
## 1. Practice Context
Responsible for the "user's practice behavior itself," with a primary focus on *what* was practiced, *how long* the practice lasted, *how well* it was performed, and whether any *progress* was made. ### Included Elements:

PracticeTimeRecord: A record of the duration of a single practice session
Take: A single recording/performance attempt
Track: A container for a single practice project/session
Lane: Represents different parts, tracks, or versions within the same Track
bpm: Practice tempo
duration / durationMs: Practice duration or recording length
evaluation: An assessment of a specific Take
audioUrl: The audio file corresponding to a specific Take

### Aggregate Root:

#### PracticeSession:
A complete practice session
Contains the practice date, user, target piece, total duration, and status
#### PracticeRecord
Check-in / Statistics
#### Track
Represents a practice recording; can be segmented
A Track contains Lanes; a Lane contains Takes

Business Rules:

A Take must belong to a specific Lane
A Lane must belong to a specific Track
The `trackId` of a Take must match the `trackId` of its Lane
The sorting order of Lanes within a Track must be unique

TODO:

Takes should be managed by the Aggregate Root—Track
e.g., `track.addTake(laneId, takeInfo);`

Domain Events:

### PracticeSessionStarted
PracticeSessionCompleted
TakeRecorded
PracticeDurationSynced
PracticeGoalAchieved
PracticeRecordCorrected

## 2. Music Library Context
Responsible for managing the musical materials owned by a user, and how these materials are organized.

### Elements:

Song
Category
SongCategory
SongLabel
artist
description
isPrivate
isArchived
isDeleted
createdUserId


### Aggregate Root:

#### Song
The Song is the core Aggregate Root
#### Category
User-defined Categories can also serve as Aggregate Roots
#### MusicCollection
TODO: Playlists / Collections

### Domain Events:

SongCreated
SongUpdated
SongArchived
SongDeleted
SongCategorized
CategoryCreated
SongShared

## 3. Segmentation Context
Responsible for "dividing a musical piece into segments suitable for practice."

## Relationships Between Contexts

### 1.
The Practice Context does not directly own the Song entity

It only references the `SongId`
Song information is provided by the Music Library Context
### 2.
The Music Library Context is not concerned with practice data

It only manages songs, categories, labels, and metadata

TODO:
Value Objects:
Bpm
AudioUrl
startMs + durationMs
Evaluation
SongName
Visibility
. . .

## Data Structures Still Needed

- [] `Track`

- [] `Lane`

- [] `Take`


## APIs Still Needed

- [] `GET /api/song/{id}/timeline`
  - Return timeline data including tracks, lanes, and takes for a song.

- [] `POST /api/track`
  - Create a new track.

- [] `PATCH /api/track/{id}`
  - Update track metadata or ordering.

- [] `DELETE /api/track/{id}`
  - Delete or archive a track.

- [] `POST /api/lane`
  - Create a new lane under a track.

- [] `PATCH /api/lane/{id}`
  - Update lane metadata or ordering.

- [] `DELETE /api/lane/{id}`
  - Delete or archive a lane.

- [] `POST /api/file/upload`
  - Upload recorded audio files to backend storage.

- [] `POST /api/take`
  - Save a newly recorded take with timeline metadata.

- [] `PATCH /api/take/{id}`
  - Edit take metadata.

- [] `DELETE /api/take/{id}`
  - Delete or archive a take.

## Next Steps

- [] Fix current backend stability and configuration issues so the service can build and run reliably.
- [] Finalize the recording-related database schema.
- [] Implement `take`-centered persistence and APIs.
- [] Enable real frontend-to-backend integration to replace the mock API layer.
- [] Add permanent audio storage and metadata persistence.
- [] Improve track and lane management for real editing workflows.
- [] Prepare the backend for future enhancements such as waveform previews, take evaluation, and metadata editing.

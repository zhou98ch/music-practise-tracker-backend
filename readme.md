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

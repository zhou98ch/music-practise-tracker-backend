CREATE TABLE IF NOT EXISTS practice_time_record (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    record_id VARCHAR(64) NOT NULL,
    user_id VARCHAR(255),
    music_id VARCHAR(255),
    bpm INT,
    date DATE,
    duration BIGINT,
    updated_at TIMESTAMP,
    CONSTRAINT uk_record_id UNIQUE (record_id)
);


CREATE TABLE users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE,
    createdDate DATE,
    updatedDate DATE
);

CREATE TABLE category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    description TEXT,
    isDeleted BOOLEAN,
    isArchived BOOLEAN,
    isPrivate BOOLEAN,
    createdUserId BIGINT,
    FOREIGN KEY (createdUserId) REFERENCES users(id),
    createdDate DATE,
    updatedDate DATE
);
CREATE TABLE song (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    artist VARCHAR(255),
    categoryId BIGINT,
    FOREIGN KEY (categoryId) REFERENCES category(id),
    description TEXT,
    isDeleted BOOLEAN,
    isArchived BOOLEAN,
    isPrivate BOOLEAN,
    createdUserId BIGINT,
    FOREIGN KEY (createdUserId) REFERENCES users(id),
    createdDate DATE,
    updatedDate DATE
);
CREATE TABLE song_category (
    song_id BIGINT NOT NULL,
    category_id BIGINT NOT NULL,
    PRIMARY KEY (song_id, category_id),
    FOREIGN KEY (song_id) REFERENCES song(id),
    FOREIGN KEY (category_id) REFERENCES category(id)
);

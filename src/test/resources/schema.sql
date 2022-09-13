CREATE TABLE IF NOT EXISTS Currency_en_zh (
    id INT PRIMARY KEY AUTO_INCREMENT,
    uuid VARCHAR(50),
    code VARCHAR(20),
    code_zh VARCHAR(20),
    is_delete INT default 0,
    rec_date TIMESTAMP,
    update_date TIMESTAMP,
    delete_date TIMESTAMP
);
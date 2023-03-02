CREATE TABLE IF NOT EXISTS member_password_history
(
	-- serial/bigserial 타입 주면 시퀀스 NEXTVAL 자동으로 적용
	id 				BIGSERIAL,
	member_id		BIGINT		 			 				NOT NULL,
	digest 			VARCHAR(256) 							NOT NULL,
	created_at 	 	TIMESTAMP 								NOT NULL 			DEFAULT now(),
	
	CONSTRAINT		pk_member_password_history_id 		PRIMARY KEY(id)
);

-- 유니크면 UNIQUE INDEX 아니면 그냥 INDEX
-- 네이밍도 어떻게 구분할지
CREATE INDEX idx_member_password_history_tuple
	-- 결합 인덱스(검색 결과 적은 거부터 해야 빠르게 검색가능)
	ON member_password_history(digest, member_id);
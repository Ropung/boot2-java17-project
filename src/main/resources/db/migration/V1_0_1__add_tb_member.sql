CREATE TABLE member
(
	-- serial 주면 시퀀스 NEXTVAL 자동으로 적용
	id 				BIGSERIAL,
	username 		VARCHAR(50) 		UNIQUE 				NOT NULL,
	password 		VARCHAR(50) 							NOT NULL,
	email 			VARCHAR(355) 		UNIQUE 				NOT NULL,
	created_at 		TIMESTAMP 								NOT NULL 			DEFAULT now(),
	last_login 		TIMESTAMP,
	
	CONSTRAINT		pk_member_id 		PRIMARY KEY(id)
);

CREATE UNIQUE INDEX udx_member_username ON member(username);
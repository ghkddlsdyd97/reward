-- 회원 테이블 생성
CREATE TABLE TB_MEMBER
(
    USER_ID    VARCHAR2(20) NOT NULL,	-- 아이디
    USER_PWD   VARCHAR2(200) NOT NULL,	-- 패스워드
    USER_NAME  VARCHAR2(20) NOT NULL,	-- 이름
    PHONE_NUM  VARCHAR2(20) NOT NULL,	-- 휴대폰번호
    USE_YN     VARCHAR2(1),		-- 사용여부(Y:사용, N:미사용)
    POINT      NUMBER(13),		-- 보유 포인트
    INST_DATE  DATE,			-- 생성일자
    UPDT_DATE  DATE,			-- 수정일자
    CONSTRAINT TB_MEMBER_PK PRIMARY KEY(USER_ID)
);

-- 보상 테이블 생성
CREATE TABLE TB_REWARD
(
    REWARD_DT         VARCHAR2(8) NOT NULL,	-- 보상일자(YYYYMMDD)
    REWARD_CONTENT    VARCHAR2(1000) NOT NULL,	-- 보상내용
    REWARD_POINT_AMT  NUMBER(13),		-- 보상 포인트 금액
    REWARD_USER_CNT   NUMBER(9),		-- 보상 선착순 횟수
    INST_DATE         DATE,			-- 생성일자
    UPDT_DATE         DATE,			-- 수정일자
    CONSTRAINT TB_REWARD_PK PRIMARY KEY(REWARD_DT)
);

-- 보상 지급 테이블 생성
CREATE TABLE TB_REWARD_PAY
(
    USER_ID           VARCHAR2(20) NOT NULL,	-- 아이디
    REWARD_PAY_DT     VARCHAR2(8) NOT NULL,	-- 보상 지급 일자(YYYYMMDD)
    REWARD_PAY_TM     VARCHAR2(8) NOT NULL,	-- 보상 지급 시간(HH24MISS)
    REWARD_POINT_AMT  NUMBER(13),		-- 보상 포인트 금액
    REWARD_CON_CNT    NUMBER(3),		-- 연속 보상 횟수
    REWARD_CON_AMT    NUMBER(13),		-- 연속 보상 포인트 금액
    REWARD_TOTAL_AMT  NUMBER(13),		-- 총 보상 포인트 금액
    CONSTRAINT TB_REWARD_PAY_PK PRIMARY KEY(USER_ID, REWARD_PAY_DT)
);

-- 보상 지급 테이블 인덱스 생성
CREATE INDEX reward_pay_idx01 ON TB_REWARD_PAY(REWARD_PAY_DT);
CREATE INDEX reward_pay_idx02 ON TB_REWARD_PAY(USER_ID, REWARD_PAY_DT);
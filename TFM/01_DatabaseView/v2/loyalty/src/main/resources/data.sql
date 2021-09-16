-- create view
CREATE VIEW T_LOYALTY_CARD_NUMBER_VIEW AS
SELECT
    id AS ID,
    loyalty_card_number AS LOYALTY_CARD_NUMBER
FROM
    t_user;
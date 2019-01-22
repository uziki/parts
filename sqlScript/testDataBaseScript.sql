USE test;
DROP TABLE IF EXISTS part;
CREATE TABLE part (
  id INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `necessary` BIT(1) NOT NULL DEFAULT b'0',
  `amount` INT(8),
  PRIMARY KEY (`id`))
  ENGINE = InnoDB
  DEFAULT CHARACTER SET = utf8;

INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Материнская плата', 1, 5);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Монитор', 1, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Мышь', 0, 3);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Клавиатура', 1, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Веб камера', 0, 1);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Геймпад', 0, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Процессор', 1, 4);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('HDD', 0, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('SSD', 1, 7);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Видеокарта', 1, 1);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Оперативная память', 1, 6);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Аудио колонки', 0, 3);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Наушники', 0, 5);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Корпус', 1, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Микрофон', 0, 45);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Блок питания', 1, 8);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Роутер', 0, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('USB хаб', 0, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('DVD привод', 0, 5);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('Сетевая карта', 0, 2);
INSERT INTO part (`name`, `necessary`, `amount`) VALUES ('USB флешка', 0, 6);
INSERT INTO degree_course (id, name, study_language) VALUES
(1, 'Informatyka Stosowana', 'POLISH'),
(2, 'Zarządzanie', 'POLISH'),
(3, 'Inżynieria systemów', 'POLISH'),
(4, 'Computer science', 'ENGLISH');

INSERT INTO speciality (id, name, degree_course_id) VALUES
(1, 'Inżynieria oprogramowania', 1),
(2, 'Danologia', 1);

INSERT INTO ministerial_learning_outcome (id, symbol, description, learning_outcome_type, krk_level, learning_outcome_area) VALUES
(1, 'MIN01', 'Ministerialny efekt ksztalcenia 1', 'SKILLS', 'LEVEL_1', 'ART_STUDIES'),
(2, 'MIN02', 'Ministerialny efekt ksztalcenia 2', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'NATURAL_SCIENCES'),
(3, 'MIN03', 'Ministerialny efekt ksztalcenia 3', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'TECHNICAL_STUDIES'),
(4, 'MIN04', 'Ministerialny efekt ksztalcenia 4', 'KNOWLEDGE', 'LEVEL_1', 'ART_STUDIES');

INSERT INTO degree_course_learning_outcome (id, symbol, description, learning_outcome_type) VALUES
(1, 'K01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS'),
(2, 'K02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES'),
(3, 'K03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES'),
(4, 'K04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE');

INSERT INTO subject_learning_outcome (id, symbol, description, learning_outcome_type) VALUES
(1, 'P01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS'),
(2, 'P02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES'),
(3, 'P03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES'),
(4, 'P04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE');

INSERT INTO subject (id, code, polish_name, english_name, subject_learning_area) VALUES
(1, 'C1', 'Bazy danych', 'Databases', 'INFORMATION_TECHNOLOGY');

INSERT INTO subject_card (id, objectives, entry_requirements, teaching_tools, basic_literature, supplementary_literature, subject_id) VALUES
(1, 'Cel przedmiotu 1,Cel przedmiotu 2', 'Wymaganie wstepne 1,Wymaganie wstepne 2','Narzędzie dydaktyczne 1,Narzedzie dydaktyczne 2',
 'Literatura podstawowa 1', 'Literatura dodatkowa 1', 1);

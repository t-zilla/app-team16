INSERT INTO degree_course (name, study_language) VALUES
('Informatyka Stosowana', 'POLISH'),
('Zarządzanie', 'POLISH'),
('Inżynieria systemów', 'POLISH'),
('Computer science', 'ENGLISH');

INSERT INTO speciality (name, degree_course_id) VALUES
('Inżynieria oprogramowania', 1),
('Danologia', 1);

INSERT INTO ministerial_learning_outcome (symbol, description, learning_outcome_type, krk_level, learning_outcome_area) VALUES
('MIN01', 'Ministerialny efekt ksztalcenia 1', 'SKILLS', 'LEVEL_1', 'ART_STUDIES'),
('MIN02', 'Ministerialny efekt ksztalcenia 2', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'NATURAL_SCIENCES'),
('MIN03', 'Ministerialny efekt ksztalcenia 3', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'TECHNICAL_STUDIES'),
('MIN04', 'Ministerialny efekt ksztalcenia 4', 'KNOWLEDGE', 'LEVEL_1', 'ART_STUDIES');

INSERT INTO degree_course_learning_outcome (symbol, description, learning_outcome_type) VALUES
('K01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS'),
('K02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES'),
('K03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES'),
('K04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE');

INSERT INTO subject_learning_outcome (symbol, description, learning_outcome_type) VALUES
('P01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS'),
('P02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES'),
('P03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES'),
('P04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE');

INSERT INTO subject_card (objectives, entry_requirements, teaching_tools, basic_literature, supplementary_literature) VALUES
('Cel przedmiotu 1,Cel przedmiotu 2', 'Wymaganie wstepne 1,Wymaganie wstepne 2','Narzędzie dydaktyczne 1,Narzedzie dydaktyczne 2',
 'Literatura podstawowa 1', 'Literatura dodatkowa 1');

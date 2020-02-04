INSERT IGNORE INTO degree_course (id, name, study_language) VALUES
(1, 'Informatyka Stosowana', 'POLISH'),
(2, 'Zarządzanie', 'POLISH'),
(3, 'Inżynieria systemów', 'POLISH'),
(4, 'Computer science', 'ENGLISH');

INSERT IGNORE INTO speciality (id, name, degree_course_id) VALUES
(1, 'Inżynieria oprogramowania', 1),
(2, 'Danologia', 1);

INSERT IGNORE INTO syllabus (id, name, study_degree, study_form, learning_profile, term_amount, entry_requirements,
                    professional_title, graduation_form, graduate_silhouette, cnps_multiplier, extended_term_amount,
                    exam_issues, degree_course_id, speciality_id) VALUES
(1, 'Program Ksztalcenia', 'FIRST_DEGREE', 'STATIONARY', 'PRACTICAL', 7, 'Wymagania wstepne', 'BACHELOR', 'Forma zaliczenia',
'Sylwetka absolwenta', 4, false, null, 1, null),
(2, 'Program Ksztalcenia 2', 'SECOND_DEGREE', 'STATIONARY', 'PRACTICAL', 7, 'Wymagania wstepne', 'BACHELOR', 'Forma zaliczenia',
'Sylwetka absolwenta', 4, false, null, 2, null),
(3, 'Program Ksztalcenia 3', 'SECOND_DEGREE', 'STATIONARY', 'PRACTICAL', 7, 'Wymagania wstepne', 'BACHELOR', 'Forma zaliczenia',
'Sylwetka absolwenta', 4, false, null, null, 1);

INSERT IGNORE INTO ministerial_learning_outcome (id, symbol, description, learning_outcome_type, krk_level, learning_outcome_area) VALUES
(1, 'MIN01', 'Ministerialny efekt ksztalcenia 1', 'SKILLS', 'LEVEL_1', 'ART_STUDIES'),
(2, 'MIN02', 'Ministerialny efekt ksztalcenia 2', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'NATURAL_SCIENCES'),
(3, 'MIN03', 'Ministerialny efekt ksztalcenia 3', 'SOCIAL_COMPETENCES', 'LEVEL_1', 'TECHNICAL_STUDIES'),
(4, 'MIN04', 'Ministerialny efekt ksztalcenia 4', 'KNOWLEDGE', 'LEVEL_1', 'ART_STUDIES');

INSERT IGNORE INTO degree_course_learning_outcome (id, symbol, description, learning_outcome_type, syllabus_id) VALUES
(1, 'K01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS', 1),
(2, 'K02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES', 1),
(3, 'K03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES', 1),
(4, 'K04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE', 1);

INSERT IGNORE INTO subject_learning_outcome (id, symbol, description, learning_outcome_type) VALUES
(1, 'P01', 'Kierunkowy efekt ksztalcenia 1', 'SKILLS'),
(2, 'P02', 'Kierunkowy efekt ksztalcenia 2', 'SOCIAL_COMPETENCES'),
(3, 'P03', 'Kierunkowy efekt ksztalcenia 3', 'SOCIAL_COMPETENCES'),
(4, 'P04', 'Kierunkowy efekt ksztalcenia 4', 'KNOWLEDGE');

INSERT IGNORE INTO degree_course_lo_to_ministerial_lo (degree_course_learning_outcome_id, ministerial_learning_outcome_id) VALUES
(1, 1);

INSERT IGNORE INTO degree_course_lo_to_subject_lo (degree_course_learning_outcome_id, subject_learning_outcome_id) VALUES
(1, 1);

INSERT IGNORE INTO researcher (id, first_name, last_name, position, academic_degree) VALUES
(1, 'Marek', 'Nowak', 'LECTURER', 'DOCTOR');

INSERT IGNORE INTO subject (id, code, polish_name, english_name, subject_learning_area, researcher_id) VALUES
(1, 'C1', 'Bazy danych', 'Databases', 'INFORMATION_TECHNOLOGY', 1);

INSERT IGNORE INTO subject_card (id, objectives, entry_requirements, teaching_tools, basic_literature, supplementary_literature, subject_id) VALUES
(1, 'Cel przedmiotu 1,Cel przedmiotu 2', 'Wymaganie wstepne 1,Wymaganie wstepne 2','Narzędzie dydaktyczne 1,Narzedzie dydaktyczne 2',
 'Literatura podstawowa 1', 'Literatura dodatkowa 1', 1);

INSERT IGNORE INTO program_content (id, lp, course_form, content, hours_amount, subject_card_id) VALUES
(1, 1, 'LECTURE', 'Treść programowa', 10, 1);

INSERT IGNORE INTO course (id, code, zzu, cnps, ects, credit_form, final_course, course_form, hours_weekly, language_level, leading_course_id, subject_id) VALUES
(1, 'c1', 90, 200, 4, 'EXAM', false, 'LECTURE', 15, null, null, 1),
(2, 'c12', 90, 200, 4, 'EXAM', false, 'PROJECT', 15, null, 1, 1);

INSERT IGNORE INTO term (id, allowed_deficit, syllabus_id) VALUES
(1, 10, 1);

INSERT IGNORE INTO subject_to_term (id, subject_id, term_id, obligatory) VALUES
(1, 1, 1, true);

INSERT IGNORE INTO subject_learning_outcome_achievement (id, description, achievement_type, subject_card_id, subject_learning_outcome_id) VALUES
(1, 'Opis', 'SUMMARY_FORMING', 1, 1);

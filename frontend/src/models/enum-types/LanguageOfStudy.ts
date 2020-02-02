export enum LanguageOfStudy {
    Polish,
    English
};

export const StrToLanguageOfStudyMap = (): Map<string, LanguageOfStudy> => {
    return new Map<string, LanguageOfStudy>()
        .set("Polski", LanguageOfStudy.Polish)
        .set("Angielski", LanguageOfStudy.English)
};

export const LanguageOfStudyToStrMap = (): Map<LanguageOfStudy, string> => {
    return new Map<LanguageOfStudy, string>()
        .set(LanguageOfStudy.Polish, "Polski")
        .set(LanguageOfStudy.English, "Angielski")
};

export const LanguageOfStudyTypeToString = (type: LanguageOfStudy): string | undefined => LanguageOfStudyToStrMap().get(type);
export const StringToLanguageOfStudy = (name: string): LanguageOfStudy | undefined => StrToLanguageOfStudyMap().get(name);

export enum FormOfStudy {
    Stationary,
    Extramural,
    Undefined
};

export const StrToFormOfStudyMap = (): Map<string, FormOfStudy> => {
    return new Map<string, FormOfStudy>()
        .set("STATIONARY", FormOfStudy.Stationary)
        .set("EXTRAMURAL", FormOfStudy.Extramural)
};

export const FormOfStudyToStrMap = (): Map<FormOfStudy, string> => {
    return new Map<FormOfStudy, string>()
        .set(FormOfStudy.Stationary, "Stacjonarne")
        .set(FormOfStudy.Extramural, "Niestacjonarne")
};

export const FormOfStudyTypeToString = (type: FormOfStudy): string | undefined => FormOfStudyToStrMap().get(type);
export const StringToFormOfStudy = (name: string): FormOfStudy | undefined => StrToFormOfStudyMap().get(name);

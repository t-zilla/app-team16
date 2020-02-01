export enum ProfessionalTitle {
    Bachelor,
    Master,
    BachelorOfEngineering
};

export const StrToProfessionalTitleMap = (): Map<string, ProfessionalTitle> => {
    return new Map<string, ProfessionalTitle>()
        .set("Licencjat", ProfessionalTitle.Bachelor)
        .set("Magister", ProfessionalTitle.Master)
        .set("Inżynier", ProfessionalTitle.BachelorOfEngineering);
};

export const ProfessionalTitleToStrMap = (): Map<ProfessionalTitle, string> => {
    return new Map<ProfessionalTitle, string>()
        .set(ProfessionalTitle.Bachelor, "Licencjat")
        .set(ProfessionalTitle.Master, "Magister")
        .set(ProfessionalTitle.BachelorOfEngineering, "Inżynier");
};

export const ProfessionalTitleTypeToString = (type: ProfessionalTitle): string | undefined => ProfessionalTitleToStrMap().get(type);
export const StringToProfessionalTitle = (name: string): ProfessionalTitle | undefined => StrToProfessionalTitleMap().get(name);

package bodrenok.lena.domain;

public enum MenuItem {

    PROJECTS("Проекты"),
    COMPANY("Компания"),
    VACANCIES("Вакансии"),
    CONTACTS("Контакты");

    public final String rusName;

    MenuItem(String rusName) {
        this.rusName = rusName;
    }
}




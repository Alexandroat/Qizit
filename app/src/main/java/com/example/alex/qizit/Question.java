package com.example.alex.qizit;

public class Question {
//
    int id;
    String categoryText;
    String questionText;
    int fkCategory;
    String dificulty;
    public Question(int id, String categoryText, String questionText,
                    int fkCategory, String dificulty) {
        this.id = id;
        this.categoryText = categoryText;
        this.questionText = questionText;
        this.fkCategory = fkCategory;
        this.dificulty = dificulty;
    }


    public Question() {
        this.id = 0;
        this.categoryText = "";
        this.questionText = "";
        this.fkCategory = 0;
        this.dificulty = "";
    }


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCategoryText() {
        return categoryText;
    }
    public void setCategoryText(String categoryText) {
        this.categoryText = categoryText;
    }
    public String getQuestionText() {
        return questionText;
    }
    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }
    public int getFkCategory() {
        return fkCategory;
    }
    public void setFkCategory(int fkCategory) {
        this.fkCategory = fkCategory;
    }
    public String getDificulty() {
        return dificulty;
    }
    public void setDificulty(String dificulty) {
        this.dificulty = dificulty;
    }
    public String toString() {
        return "Question [id=" + id + ", categoryText=" + categoryText
                + ", questionText=" + questionText + ", fkCategory="
                + fkCategory + ", dificulty=" + dificulty + "]";
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((categoryText == null) ? 0 : categoryText.hashCode());
        result = prime * result
                + ((dificulty == null) ? 0 : dificulty.hashCode());
        result = prime * result + fkCategory;
        result = prime * result + id;
        result = prime * result
                + ((questionText == null) ? 0 : questionText.hashCode());
        return result;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Question other = (Question) obj;
        if (categoryText == null) {
            if (other.categoryText != null)
                return false;
        } else if (!categoryText.equals(other.categoryText))
            return false;
        if (dificulty == null) {
            if (other.dificulty != null)
                return false;
        } else if (!dificulty.equals(other.dificulty))
            return false;
        if (fkCategory != other.fkCategory)
            return false;
        if (id != other.id)
            return false;
        if (questionText == null) {
            if (other.questionText != null)
                return false;
        } else if (!questionText.equals(other.questionText))
            return false;
        return true;
    }
}
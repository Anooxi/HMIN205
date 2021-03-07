package fr.maximereiter.tp3;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PlanningModel extends ViewModel {
    public MutableLiveData<String> rdv1 = new MutableLiveData<>();
    public MutableLiveData<String> rdv2 = new MutableLiveData<>();
    public MutableLiveData<String> rdv3 = new MutableLiveData<>();
    public MutableLiveData<String> rdv4 = new MutableLiveData<>();

    public PlanningModel(){
        rdv1.setValue("Rencontre client Dupont");
        rdv2.setValue("Travailler le dossier recrutement");
        rdv3.setValue("Réunion équipe");
        rdv4.setValue("Préparation dossier vente");
    }

    public String getRdv1() {
        return rdv1.getValue();
    }

    public String getRdv2() {
        return rdv2.getValue();
    }

    public String getRdv3() {
        return rdv3.getValue();
    }

    public String getRdv4() {
        return rdv4.getValue();
    }

    public void setRdv1(String rdv1) {
        this.rdv1.setValue(rdv1);
    }

    public void setRdv2(String rdv2) {
        this.rdv2.setValue(rdv2);
    }

    public void setRdv3(String rdv3) {
        this.rdv3.setValue(rdv3);
    }

    public void setRdv4(String rdv4) {
        this.rdv4.setValue(rdv4);
    }

}

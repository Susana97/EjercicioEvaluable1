package ejercicioevaluable1;

import java.io.Serializable;

public class Venta implements Serializable {
    
    private int localidad;
    private int procesador;
    private int memoria;
    private int discoDuro;
    private int monitor;
    private boolean windows10;
    private boolean lectorDvd;
    private boolean Wifi;
    private boolean BackupRestore;

    @Override
    public String toString() {
        return "Venta{" + "localidad=" + localidad + ", procesador=" + procesador + ", memoria=" + memoria + ", discoDuro=" + discoDuro + ", monitor=" + monitor + ", windows10=" + windows10 + ", lectorDvd=" + lectorDvd + ", Wifi=" + Wifi + ", BackupRestore=" + BackupRestore + '}';
    }

    public Venta(int localidad, int procesador, int memoria, int monitor,  int discoDuro, boolean windows10, boolean lectorDvd, boolean Wifi, boolean BackupRestore) {
        this.localidad = localidad;
        this.procesador = procesador;
        this.memoria = memoria;
        this.monitor = monitor;
        this.discoDuro = discoDuro;
        this.windows10 = windows10;
        this.lectorDvd = lectorDvd;
        this.Wifi = Wifi;
        this.BackupRestore = BackupRestore;
        windows10 = true;
        lectorDvd = true;
        Wifi = false;
        BackupRestore = false;
    }

    public int getLocalidad() {
        return localidad;
    }

    public int getMonitor() {
        return monitor;
    }

    public int getProcesador() {
        return procesador;
    }

    public int getMemoria() {
        return memoria;
    }

    public int getDiscoDuro() {
        return discoDuro;
    }

    public boolean isWindows10() {
        return windows10;
    }

    public boolean isLectorDvd() {
        return lectorDvd;
    }

    public boolean isWifi() {
        return Wifi;
    }

    public boolean isBackupRestore() {
        return BackupRestore;
    }

    public void setMonitor(int monitor) {
        this.monitor = monitor;
    }

    public void setLocalidad(int localidad) {
        this.localidad = localidad;
    }

    public void setProcesador(int procesador) {
        this.procesador = procesador;
    }

    public void setMemoria(int memoria) {
        this.memoria = memoria;
    }

    public void setDiscoDuro(int discoDuro) {
        this.discoDuro = discoDuro;
    }

    public void setWindows10(boolean windows10) {
        this.windows10 = windows10;
    }

    public void setLectorDvd(boolean lectorDvd) {
        this.lectorDvd = lectorDvd;
    }

    public void setWifi(boolean Wifi) {
        this.Wifi = Wifi;
    }

    public void setBackupRestore(boolean BackupRestore) {
        this.BackupRestore = BackupRestore;
    }
    
    
}

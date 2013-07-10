package Entidades;
import Main.SIRP;
public class Evaluacion {
    private int id_blo;
    private int id_tip;
    private int id_tem;
    private int id_alu;
    private int nota;

    public Evaluacion(int id_blo, int id_tip, int id_tem, int id_alu, int nota) {
        this.id_blo = id_blo;
        this.id_tip = id_tip;
        this.id_tem = id_tem;
        this.id_alu = id_alu;
        this.nota = nota;
    }

    public int getId_blo() {
        return id_blo;
    }

    public int getId_tip() {
        return id_tip;
    }

    public int getId_tem() {
        return id_tem;
    }

    public int getId_alu() {
        return id_alu;
    }

    public int getNota() {
        return nota;
    }

    public void setId_blo(int id_blo) {
        this.id_blo = id_blo;
    }

    public void setId_tip(int id_tip) {
        this.id_tip = id_tip;
    }

    public void setId_tem(int id_tem) {
        this.id_tem = id_tem;
    }

    public void setId_alu(int id_alu) {
        this.id_alu = id_alu;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }
    
    public void insert(){
        String sql = "INSERT INTO `registro`.`evaluacion`(`id_blo`,`id_tip`,`id_tem`,`id_alu`,`nota`) VALUES ( '"
                + id_blo+"','"
                + id_tip+"','"
                + id_tem+"','"
                + id_alu+"','"
                + nota+"'); ";
        SIRP.con.consulta(sql);
    }
    
    public void update(){
        String sql ="UPDATE `registro`.`evaluacion` SET `nota`='"
                + nota+"' WHERE `id_tip`='"
                + id_tip+"' AND `id_tem`='"
                + id_tem+"' AND `id_alu`='"
                + id_alu+"'; ";
        SIRP.con.consulta(sql);
    }
    
    public void delete(){
        String sql = "DELETE FROM `registro`.`evaluacion` WHERE `id_tip`='"
                + id_tip+"' AND `id_tem`='"
                + id_tem+"' AND `id_alu`='"
                + id_alu+"'; ";
        SIRP.con.consulta(sql);
    }
}

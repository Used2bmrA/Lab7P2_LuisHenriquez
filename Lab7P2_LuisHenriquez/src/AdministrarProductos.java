
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdministrarProductos {
    private ArrayList<Producto> productos = new ArrayList();
    private File archivo = null;

    public AdministrarProductos() {
    }
    
    public AdministrarProductos(String path) {
        archivo = new File(path);
    }

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    @Override
    public String toString() {
        return "AdministrarProductos{" + "productos=" + productos + ", archivo=" + archivo + '}';
    }
    
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Producto p : productos) {
                bw.write(p.getId()+ ",");
                bw.write(p.getName()+ ",");
                bw.write(p.getCategory()+ ",");
                bw.write(p.getPrice()+ ",");
                bw.write(p.getAisle()+ ",");
                bw.write(p.getBin()+ ",");
            }
            bw.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc2 = null;
        productos = new ArrayList();
        if (archivo.exists()) {
            try {
                sc2 = new Scanner(archivo);
                sc2.useDelimiter(",");
                while (sc2.hasNext()) {
                    productos.add(new Producto(sc2.nextInt(), sc2.next(), sc2.next(), sc2.nextDouble(), sc2.nextInt(), sc2.nextInt()));
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            sc2.close();
        }else{
            System.out.println("No");
        }
    }    
    
}

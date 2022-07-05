
import controlador.FrutaController;
import controlador.FrutaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.FrutaModel;
import modelo.FrutaModelImpl;
import vista.fruta.FrutaView;
import vista.fruta.FrutaViewImpl;
import vista.VistaGlobal;

public class Main {

    public static void main(String[] args) {

        //Fruta
        FrutaModel frutaModel = new FrutaModelImpl();

        FrutaView frutaView1 = new FrutaViewImpl();
        List<FrutaView> frutaViews = new ArrayList<FrutaView>();
        frutaViews.add(frutaView1);

        FrutaController frutaController = new FrutaControllerImpl();

        frutaController.setup(frutaModel, frutaViews);

        VistaGlobal vista1 = new VistaGlobal(frutaView1);
        vista1.display();

    }

}

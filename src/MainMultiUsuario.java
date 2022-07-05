
import controlador.FrutaController;
import controlador.FrutaControllerImpl;
import java.util.ArrayList;
import java.util.List;
import modelo.FrutaModel;
import modelo.FrutaModelImpl;
import vista.fruta.FrutaView;
import vista.fruta.FrutaViewImpl;
import vista.VistaGlobal;

public class MainMultiUsuario {

    public static void main(String[] args) {

        //Fruta
        FrutaModel frutaModel = new FrutaModelImpl();

        FrutaView frutaView1 = new FrutaViewImpl();
        FrutaView frutaView2 = new FrutaViewImpl();
        List<FrutaView> frutaViews = new ArrayList<FrutaView>();
        frutaViews.add(frutaView1);
        frutaViews.add(frutaView2);

        FrutaController frutaController = new FrutaControllerImpl();

        frutaController.setup(frutaModel, frutaViews);

        VistaGlobal vista1 = new VistaGlobal(frutaView1);
        VistaGlobal vista2 = new VistaGlobal(frutaView2);
        vista1.display();
        vista2.display();

    }

}

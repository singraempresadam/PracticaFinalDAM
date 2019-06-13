package control.paraUis;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import control.Controller;
import control.paraUis.cirujano.paraUiVentanaCirujano;
import control.paraUis.medico.paraUiVentanaMedico;
import control.paraUis.paciente.paraUiVentanaPaciente;
import vista.ventanaPrincipal;

public class paraUiVentanaPrincipal extends ventanaPrincipal{
	private Validator validator;
	private Controller control;
	private final int DIA_SIGUIENTE_AUMENTO=1;
	private final int HORA_INICIO_DIA=10;
	private final int MINUTO_INICIO_DIA=0;
	public paraUiVentanaPrincipal ()
	{
		super();
		this.setControl(new Controller());
		this.setValidator(new Validator());
		this.getLblFechaYHora().setText(this.getControl().fechaYHora());
		crearListeners();
	}

	private void crearListeners() {
		eventoBotonCrearVentanaPacientes();
		eventoBotonCrearVentanaMedicos();
		eventoBotonCrearVentanaCirujanos();
		eventoBotonUnaHora();
		eventoBotonTresHoras();
		eventoBotonDoceHoras();
		eventoBotonVeinticuatroHoras();
		eventoBotonDia();
	}

	private void eventoBotonCrearVentanaPacientes() {
		this.getBotonPaciente().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearVentanaPacientes();
			}
		});
	}
	private void eventoBotonCrearVentanaMedicos() {
		this.getBotonMedico().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearVentanaMedicos();
			}
		});
	}
	private void eventoBotonCrearVentanaCirujanos() {
		this.getBotonCirujano().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearVentanaCirujanos();
			}
		});
	}
	private void eventoBotonUnaHora() {
		this.getBtnUnaHora().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			    aumentarHora(obtenerAumentoDeBoton(arg0));
			}
		});
	}
	private void eventoBotonTresHoras() {
		this.getBtnTresHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aumentarHora(obtenerAumentoDeBoton(arg0));
			}
		});
	}
	private void eventoBotonDoceHoras() {
		this.getBtnDoceHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aumentarHora(obtenerAumentoDeBoton(arg0));
			}
		});
	}
	private void eventoBotonVeinticuatroHoras() {
		this.getBtnVeinticuatroHoras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aumentarHora(obtenerAumentoDeBoton(arg0));
			}
		});
	}
	private void eventoBotonDia() {
		this.getBtnUnDia().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				aumentarUnDiaYEstablecerHoraALasDiez();
			}
		});
	}
	
	private void crearVentanaPacientes() {
		paraUiVentanaPaciente paraUiVentanaPaciente = new paraUiVentanaPaciente(this.getControl(),this.getValidator());
		paraUiVentanaPaciente.setVisible(true);
	}
	private void crearVentanaMedicos() {
		paraUiVentanaMedico paraUiVentanaMedico = new paraUiVentanaMedico(this.getControl(),this.getValidator());
		paraUiVentanaMedico.setVisible(true);
	}
	private void crearVentanaCirujanos() {
		paraUiVentanaCirujano paraUiVentanaCirujano = new paraUiVentanaCirujano(getControl(),this.getValidator());
		paraUiVentanaCirujano.setVisible(true);
	}
	
	private int obtenerAumentoDeBoton(MouseEvent arg0) {
		String textoBoton = ((JButton)arg0.getSource()).getText();
		String[] textoFragmentado = textoBoton.split(" ");
		String aumento=textoFragmentado[1];
		return Integer.valueOf(aumento);
	}
	private void aumentarHora(int obtenerAumentoDeBoton) {
		this.getControl().aumentarHora(obtenerAumentoDeBoton);
		getLblFechaYHora().setText(this.getControl().fechaYHora());
	}
	private void aumentarUnDiaYEstablecerHoraALasDiez() {
		this.getControl().establecerHora(this.get_DIA_SIGUIENTE_AUMENTO(),this.get_HORA_INICIO_DIA(),this.get_MINUTO_INICIO_DIA());
		getLblFechaYHora().setText(this.getControl().fechaYHora());
	}
	
	public Controller getControl() {
		return control;
	}
	private Validator getValidator(){
		return this.validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}
	public void setControl(Controller control) {
		this.control = control;
	}
	public int get_DIA_SIGUIENTE_AUMENTO() {
		return DIA_SIGUIENTE_AUMENTO;
	}
	public int get_HORA_INICIO_DIA() {
		return HORA_INICIO_DIA;
	}
	public int get_MINUTO_INICIO_DIA() {
		return MINUTO_INICIO_DIA;
	}
}

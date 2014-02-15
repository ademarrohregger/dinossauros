package colecaodedinossauros.dinossauros;

import java.util.ArrayList;
import java.util.List;

public class DinoRepository {
	
	private List<Dino> dinos;
	
	public DinoRepository() {
		this.dinos = new ArrayList<Dino>();
	}
	
	public void addDinos(String... names) {
		for (String name : names) {
			dinos.add(new Dino(name));
		}
	}
	
	public List<String> listNames() {
		List<String> dinoNames = new ArrayList<String>();
		for (Dino dino : dinos) {
			dinoNames.add(dino.getName());
		}
		return dinoNames;
	}
	
	public boolean empty() {
		if (dinos != null) {
			return dinos.isEmpty();
		}
		return true;
	}

}



public enum CardTable {
	//all cards, /sec, spec boost, dis all card row + column
	//Investor imp /sec
	//pipe /around + 450%
	//meat /below  + 1500%
	//skull /right + 1200%
	//armor /column + 450%
	//watchtower /row + 450%
	
	
	InverstorImp(0, 0, 0, 0, 0, 120),
	Pipe(0, 0, 0, 0, 4.5, 0),
	Meat(0, 0, 0, 15, 0, 0),
	Skull(0, 0, 12, 0, 0, 0),
	Armor(0, 4.5, 0, 0, 0, 0),
	WatchTower(4.5, 0, 0, 0, 0, 0)
	;

	double rowBoost;
	double columnBoost;
	double rightBoost;
	double belowBoost;
	double aroundBoost;
	double perSec;
	
	CardTable(double row, double column, double right, double below, double around, double perS) {
		double rowBoost = row;
		double columnBoost = column;
		double rightBoost = right;
		double belowBoost = below;
		double aroundBoost = around;
		double perSec = perS;
	}

}
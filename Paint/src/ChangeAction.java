


public class ChangeAction {
	private PData data;
	private PShape source;
	public static final int changeLoc = 0;
	public static final int changeColor = 1;
	public static final int created = 3;
	public static final int Changefilled = 4;
	public static final int ChangeStroke = 5;
	public static final int deleted = 6;
	public int actionPerformed;
	

	ChangeAction(PShape s,int action){
		data = s.getDataCopy();
		actionPerformed = action;
		source = s;
	}
	
	
	public void reset(){
		switch(actionPerformed){
		case changeColor:
			source.setColor(data.color);
			break;
		case Changefilled:
			source.setFilled(data.filled);
			break;
		case ChangeStroke:
			source.data.stroke = data.stroke;
			break;
		}
	}
	
	
	
	public PData getData() {
		return data;
	}
	public void setData(PData data) {
		this.data = data;
	}
	public PShape getSource() {
		return source;
	}
	public void setSource(PShape source) {
		this.source = source;
	}
	
	public int getActionPerformed() {
		return actionPerformed;
	}

	public void setActionPerformed(int actionPerformed) {
		this.actionPerformed = actionPerformed;
	}

}

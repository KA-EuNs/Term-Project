
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AssetGUI gui = new AssetGUI();
		gui.setVisible(true);
		
		Assets assets = new Assets();
		assets.WriteOutput();
		
		//AssetFile asFile = new AssetFile();
		
		assets.writeAssets(assets.getcurrentAsset());
		assets.calPercent(assets);
		//gui.curAsset = asFile.cuAsset;
		//gui.curAsset = Integer.parseInt(asFile.line);
		
	}

}

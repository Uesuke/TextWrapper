package model;

public class TextWrapperLogic {
	
	public void execute(WrappingBox wrappingBox) {
		String[] inputArray = wrappingBox.getContent().split("\n");
		for(String input : inputArray) {
			input = spaceEraser(input);	//先頭の空白文字を削除
			if(wrappingBox.isExecutesInserter()) {
				input = seqenceInserter(input);	//「"」の直前に\を挿入
			}
			input = htmlSpetialCharReplacer(input);	//「<,>」をHTML特殊文字に置き換え
			input = textWrapper(wrappingBox.getFormer(), wrappingBox.getLatter(), input);
			wrappingBox.getOutputList().add(input);
		}
	}
	
	//inputに受けた文字列を編集し、formerとlatterではさんだ文字列を返す
	public static String textWrapper(String former, String latter, String input) {
		String result = former + input + latter;
		return result;
	}
	
	//テキストエディタなどで編集したHTMLファイルの文頭にはスペースやインデントが入っている。
	//それらが出力結果に入っていてもサーブレット自体は動くが、美しくないので消去する。
	//引数として文字列を受け、頭文字が条件に該当すれば消去していく
	public static String spaceEraser(String input) {
		String result = null;
		StringBuilder sb = new StringBuilder(input);
		boolean check = false;
		if(sb.charAt(0) == ' ' || sb.charAt(0) == '\t' || sb.charAt(0) == '　') {
			check = true;
		}
		while(check == true) {
			sb.delete(0,1);
			check = false;
			if(sb.charAt(0) == ' ' || sb.charAt(0) == '\t' || sb.charAt(0) == '　') {
				check = true;
			}
		}
		result = sb.toString();
		return result;
	}
	
	//実行結果をブラウザに表示する際、<html>などがブラウザにコードとして認識されてしまうため
	//<などのHTML上で意味をもつ文字を特殊文字に置換する
	public static String htmlSpetialCharReplacer(String input) {
		String result = input;
		
		result = result.replace("<", "&lt;");
		result = result.replace(">", "&gt;");
		
		return result;
	}
	
	//HTMLファイルに含まれる"に¥を振って回るのは煩わしい
	//"を\"に置き換えるメソッド
	public static String seqenceInserter(String input){
		String result = input;
		result = result.replace("\"", "\\\"");
		return result;
	}
}

package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WrappingBox implements Serializable {
    private String former;
    private String latter;
//    private boolean executesEraser;
    private boolean executesInserter;
    private String content;
    private List<String> outputList = new ArrayList<>();
    
    public WrappingBox(String former, String latter, boolean executesInserter, String content) {
    	this.former = former;
    	this.latter = latter;
//    	this.executesEraser = executesEraser;
    	this.executesInserter = executesInserter;
    	this.content = content;
    }

    public void setFormer(String former) {
        this.former = former;
    }

    public String getFormer() {
        return former;
    }

    public void setLatter(String latter) {
        this.latter = latter;
    }

    public String getLatter() {
        return latter;
    }

//    public void setExecutesEraser(boolean executesEraser) {
//        this.executesEraser = executesEraser;
//    }
//
//    public boolean isExecutesEraser() {
//        return executesEraser;
//    }
    
    public void setExecutesInserter(boolean executesInserter) {
        this.executesInserter = executesInserter;
    }

    public boolean isExecutesInserter() {
        return executesInserter;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setOutputList(List<String> outputList) {
        this.outputList = outputList;
    }

    public List<String> getOutputList() {
        return outputList;
    }
}

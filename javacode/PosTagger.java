/*postagger.java */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import edu.stanford.nlp.ling.HasWord;
import edu.stanford.nlp.ling.Sentence;
import edu.stanford.nlp.ling.TaggedWord;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;

import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Date;


import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author aditya
 */
public class PosTagger {
    
    private MaxentTagger tagger;

    public PosTagger ( String pathToModel ) throws IOException, ClassNotFoundException {
        tagger = new MaxentTagger(pathToModel);
    }

    public String getTaggedSentence ( String stringToTag ) {
        String result = "";
        List<List<HasWord>> sentences = tagger.tokenizeText(new StringReader(stringToTag));
        for ( List<HasWord> sentence : sentences ) {
            ArrayList<TaggedWord> tSentence = tagger.tagSentence(sentence);
            result += Sentence.listToString(tSentence, false);
        }
        return result;
    }
    
    public void getFrequencies(String taggedString){
        String[] getTags = taggedString.split("\\s+");
        String noun1 = "NNS";
        String noun2 = "NN";
        String noun3 = "NNP";
        String noun4 = "NNPS";
        String verb1 = "VB";
        String verb2 = "VBD";
        String verb3 = "VBG";
        String verb4 = "VBN";
        String verb5 = "VBP";
        String verb6 = "VBZ";
        String preposition = "IN";
        String superlative1 = "JJS";
        String superlative2 = "RBS";
        String comparative1 = "JJR";
        String comparative2 = "RBR";
        String determiner1 = "DT";
        String determiner2 = "PDT";
        String determiner3 = "WDT";
        String adjective = "JJ";
        String pronoun = "PRP";
        ArrayList<String> nounlist = new ArrayList<String>();
        ArrayList<String> verblist = new ArrayList<String>();
        ArrayList<String> prepositionlist = new ArrayList<String>();
        ArrayList<String> superlativelist = new ArrayList<String>();
        ArrayList<String> comparativelist = new ArrayList<String>();
        ArrayList<String> determinerlist = new ArrayList<String>();
        ArrayList<String> adjectivelist = new ArrayList<String>();
        ArrayList<String> pronounlist = new ArrayList<String>();
        
        for(int i=0;i<getTags.length;i++){
            String[] splitted = getTags[i].split("/");
//            System.out.println(splitted[1]);
            if (splitted[1].equals(noun1)|splitted[1].equals(noun2)|splitted[1].equals(noun3)|splitted[1].equals(noun4)){
                nounlist.add(splitted[0]);
            }
            else if (splitted[1].equals(verb1)|splitted[1].equals(verb2)|splitted[1].equals(verb3)|splitted[1].equals(verb4)|splitted[1].equals(verb5)|splitted[1].equals(verb6)){
                verblist.add(splitted[0]);
            }
            else if (splitted[1].equals(preposition)){
                prepositionlist.add(splitted[0]);
            }
            else if (splitted[1].equals(superlative1)|splitted[1].equals(superlative2)){
                superlativelist.add(splitted[0]);
            }
            else if (splitted[1].equals(comparative1)|splitted[1].equals(comparative2)){
                comparativelist.add(splitted[0]);
            }
            else if (splitted[1].equals(determiner1)|splitted[1].equals(determiner2)|splitted[1].equals(determiner3)){
                determinerlist.add(splitted[0]);
            }
            else if (splitted[1].equals(adjective)){
                adjectivelist.add(splitted[0]);
            }
            else if (splitted[1].equals(pronoun)){
                pronounlist.add(splitted[0]);
            }
        }
        System.out.println(nounlist);
        System.out.println("--------------------------------------");
    }
    
    public static void main ( String[] args ) throws IOException, ClassNotFoundException {
        PosTagger posTagger = new PosTagger("/home/aditya/Downloads/stanford-postagger-2013-04-04/models/english-left3words-distsim.tagger");
        File indirectory = new File("/home/aditya/Desktop/sampleroutput/"); 
//        File indirectory = new File("/home/aditya/Desktop/author_profiling/pan_author_profiling_training_data/enoutput/");
        File[] inarray;  
        inarray=new File[10];        
        inarray=indirectory.listFiles();
        ArrayList<String> eachfile = new ArrayList<String>();       
            Date date = new Date();
            System.out.println(date);
        for (int j = 0; j < inarray.length; j++)
        {
                File path=inarray[j];
            BufferedReader br = new BufferedReader(new FileReader(path));
            String data = "";
            String c ="";
            while((c = br.readLine())!= null){
                data = data + c;
//                System.out.println(data); 
//                System.out.println("------");
            }   
            eachfile.add(data);
            String finalTag = posTagger.getTaggedSentence(eachfile.get(j).toString());
//            System.out.println(j);
//            System.out.println(finalTag);
//            System.out.println("------");
//            System.out.println(fulltag.size());
            posTagger.getFrequencies(finalTag);
        } 
        Date date2 = new Date();
            System.out.println(date2);
    }
}
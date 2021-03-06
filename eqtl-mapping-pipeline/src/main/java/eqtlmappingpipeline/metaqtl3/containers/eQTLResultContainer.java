/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eqtlmappingpipeline.metaqtl3.containers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import umcg.genetica.containers.Pair;
import umcg.genetica.io.trityper.TriTyperGeneticalGenomicsDataset;
import umcg.genetica.io.trityper.eQTLTextFile;

/**
 *
 * @author harmjan
 */
public class eQTLResultContainer {

    private EQTL[] tmpEQTLBuffer;
    private EQTL[] finalEQTLs;
    public int totalcounter = 0;
    private int m_counter = 0;
    private int m_result_counter = 0;
    private int m_maxResults = 0;
    private int m_numdatasets = 0;
    public double highestP = Double.MAX_VALUE;
    private int nrSet;
    private int nrInFinalBuffer = 0;

    public eQTLResultContainer(int size, int finalsize, int datasets) {
        tmpEQTLBuffer = new EQTL[size];
        m_maxResults = finalsize;
        m_result_counter = 0;
        m_numdatasets = datasets;
    }

    public int getCounter() {
        return m_counter;
    }

    public void resetResultCounter() {
        m_result_counter = 0;
    }

    public String getNextResult(WorkPackage[] workPackages, Integer[][] probeTranslation, TriTyperGeneticalGenomicsDataset[] gg, int maxCisDistance) {
        if (m_result_counter < finalEQTLs.length) {
            String output = finalEQTLs[m_result_counter].getDescription(workPackages, probeTranslation, gg, maxCisDistance);

            m_result_counter++;
            return output;
        } else {
            return null;
        }

    }

//    public String getNextResultAndCleanup(WorkPackage[] workPackages, Integer[][] probeTranslation, TriTyperGeneticalGenomicsDataset[] gg, int maxCisDistance, boolean permuting) {
//        if (permuting) {
//            if (m_result_counter < finalEQTLs.length && finalEQTLs[m_result_counter] != null && finalEQTLs[m_result_counter].set) {
//
//                String output = finalEQTLs[m_result_counter].getDescription(workPackages, probeTranslation, gg, maxCisDistance);
//
//                if (output != null) {
//                    String[] realout = output.split("\t");
//                    String hugo = null;
//                    if (realout[eQTLTextFile.HUGO] == null) {
//                        hugo = "-";
//                    } else {
//                        hugo = realout[eQTLTextFile.HUGO];
//                    }
//                    String ln = realout[0] + "\t" + realout[1] + "\t" + realout[4] + "\t" + hugo;
//
//                    finalEQTLsCopy[m_result_counter] = null;
//                    finalEQTLs[m_result_counter] = null;
//                    m_result_counter++;
//                    return ln;
//                } else {
//                    m_result_counter++;
//                    return null;
//                }
//
//
//            } else {
//                return null;
//            }
//        } else {
//            if (m_result_counter < finalEQTLs.length && finalEQTLs[m_result_counter] != null && finalEQTLs[m_result_counter].set) {
//                String output = finalEQTLs[m_result_counter].getDescription(workPackages, probeTranslation, gg, maxCisDistance);
//                finalEQTLsCopy[m_result_counter] = null;
//                finalEQTLs[m_result_counter] = null;
//
//                m_result_counter++;
//
//                return output;
//            } else {
//                return null;
//            }
//        }
//
//
//    }
   
}

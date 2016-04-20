package it.slidingblock.dlv;

import java.util.*;
import it.slidingblock.core.*;
import it.slidingblock.core.block.*;
import java.awt.*;

public  class Interface{

public int key;
public Interface(){
key= 0 ;
}
public ArrayList<Spostamenti> compute(World w){
long begin=System.currentTimeMillis();
int maxint= 0 ;
Point exitPoint=w.getMatrix().getExitCell();
ExitCell exit= new ExitCell(exitPoint.x,exitPoint.y);
Set<BKey> bKeyDLV= new HashSet<BKey>();
ArrayList<Block> blocchiJ=w.getBlocks();
Set<PosSposSu> posSposSu= new HashSet<PosSposSu>();
ArrayList<Spostamenti> spostamenti= new ArrayList<Spostamenti>();
for(Block b:blocchiJ)
{
if(b.getId()>maxint)
maxint=b.getId();
posSposSu.add( new PosSposSu(b.getId(),b.getId()));
posSposSu.add( new PosSposSu(b.getId(), 0 ));
if(b instanceof KeyBlock)
key=b.getId();
Point bk=w.getMatrix().getFirstPoint(b.getId());
bKeyDLV.add( new BKey(b.getId(),bk.y,bk.x, 0 ));
}
Point keyPoint=w.getMatrix().getFirstPoint(key);
if(keyPoint.y==exit.x&&keyPoint.x==exit.y)
return spostamenti;
resolve(spostamenti,key,w.getMatrix().getDiverse(),posSposSu,w.getMatrix().getCelle(),bKeyDLV,exit,maxint,w.getMatrix().getUp(),w.getMatrix().getLeft(),w.getMatrix().getRight(),w.getMatrix().getDown(),w.getMatrix().getAdiacenze());
System.out.println( "Tempo impiegato: " +(System.currentTimeMillis()-begin)+ " millisecondi" );
System.out.println( "Tempo impiegato: " +(System.currentTimeMillis()-begin)/ 1000 + " secondi" );
System.out.println( "Tempo impiegato: " +((System.currentTimeMillis()-begin)/ 1000 )/ 60 + " minuti" );
return spostamenti;
}
public  void  resolve(ArrayList<Spostamenti> spostamenti,int key,Set<Diversa> diversa,Set<PosSposSu> posSposSu,Set<Contiene> contiene,Set<BKey> bKeyDLV,ExitCell exit,int maxint,Set<Adiacenze> up,Set<Adiacenze> left,Set<Adiacenze> right,Set<Adiacenze> down,Set<Adiacenze> adiacenze){

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation EXECUTING JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_EXECUTING.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'key::key' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(diversa,"diversa"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'diversa::diversa' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(diversa,"diversa"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(contiene,"contiene"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'contiene::contiene' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(contiene,"contiene"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(posSposSu,"posSpostSu"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'posSposSu::posSpostSu' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(posSposSu,"posSpostSu"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'bKeyDLV::bKey' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'exit::uscita' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(right,"right"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'right::right' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(right,"right"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(left,"left"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'left::left' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(left,"left"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(up,"up"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'up::up' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(up,"up"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(down,"down"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'down::down' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(down,"down"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(adiacenze,"adiacente"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'adiacenze::adiacente' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(adiacenze,"adiacente"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'spostamenti::sposta' in module EXECUTING.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_EXECUTING=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING.toString());
_JDLV_PROGRAM_EXECUTING.getFiles().clear();
_JDLV_PROGRAM_EXECUTING.addFile("./solver.txt");
_JDLV_INVOCATION_EXECUTING.addOption("-n=1, -N="+maxint);
_JDLV_INVOCATION_EXECUTING.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_EXECUTING);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution EXECUTING program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_EXECUTING.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_EXECUTING.getInputProgram().getCompleteText(),0)+'\n'+"Files execution: ./solver.txt");
_JDLV_INVOCATION_EXECUTING.run();
while(_BUFFERED_HANDLER_EXECUTING.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING=_BUFFERED_HANDLER_EXECUTING.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(spostamenti, "sposta",_temporary_JDLV_MODELEXECUTING,Spostamenti.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "spostamenti " + spostamenti.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(spostamenti,0));
}
if(_JDLV_INVOCATION_EXECUTING.haveModel()==false){
if(maxint< 40 )
maxint+= 3 ;
resolve(spostamenti,key,diversa,posSposSu,contiene,bKeyDLV,exit,maxint,up,left,right,down,adiacenze);
}
if(!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_EXECUTING){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
}
_JDLV_PROGRAM_EXECUTING.cleanText();

	// ---- END - prepareJDLVCall ---- 
}
}


package it.slidingblock.dlv;

import java.util.*;
import it.slidingblock.core.*;
import it.slidingblock.core.block.*;
import java.awt.*;

public  class Interface{

public int dim, turno= 1 , key= 0 ;
public Interface(int dim){
 this .dim=dim;
}
public ArrayList<Spostamenti> compute(World w,int max){
Point exitPoint=w.getMatrix().getExitCell();
ExitCell exit= new ExitCell(exitPoint.x,exitPoint.y);
Set<Blocco> blocchiDLV= new HashSet<Blocco>();
Set<BKey> bKeyDLV= new HashSet<BKey>();
ArrayList<Block> blocchiJ=w.getBlocks();
ArrayList<Spostamenti> spostamenti= new ArrayList<Spostamenti>();
for(Block b:blocchiJ)
{
if(b instanceof KeyBlock)
key=b.getId();
Point bk=w.getMatrix().getFirstPoint(b.getId());
bKeyDLV.add( new BKey(b.getId(),bk.y,bk.x, 0 ));
ArrayList<Point> temp=w.getMatrix().getPosition(b.getId());
for(Point p:temp)
blocchiDLV.add( new Blocco(b.getId(),p.x,p.y));
}
for(int i= 1 ;i<max;i++)
{

	// ---- START - startModuleIncrement ---- 

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation Solver JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_Solver=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_Solver.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_Solver=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_Solver;

	// ---- END - startProgram ---- 

	// ---- END - startModuleIncrement ---- 

	// ---- START - endModuleIncrement ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add code in Solver module: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode("turno("+(i)+").", 0));
_JDLV_PROGRAM_BUFFER_Solver.append("turno("+(i)+").");

	// ---- END - endModuleIncrement ---- 
}

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation Solver JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_Solver=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_Solver.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_Solver=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_Solver;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(dim,"dim"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'dim::dim' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(dim,"dim"), 0));
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'key::key' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"), 0));
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(turno,"turno"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'turno::turno' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(turno,"turno"), 0));
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(blocchiDLV,"blocco"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'blocchiDLV::blocco' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(blocchiDLV,"blocco"), 0));
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'bKeyDLV::bKey' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"), 0));
_JDLV_PROGRAM_Solver.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'exit::uscita' in module Solver:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'spostamenti::sposta' in module Solver.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_Solver=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_Solver.addText(_JDLV_PROGRAM_BUFFER_Solver.toString());
_JDLV_PROGRAM_Solver.getFiles().clear();
_JDLV_PROGRAM_Solver.addFile("./solver.txt");
_JDLV_INVOCATION_Solver.addOption("-n=1, -N=50");
_JDLV_INVOCATION_Solver.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_Solver.append("");
_JDLV_INVOCATION_Solver.setInputProgram(_JDLV_PROGRAM_Solver);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_Solver=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_Solver);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution Solver program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_Solver.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_Solver.getInputProgram().getCompleteText(),0)+'\n'+"Files execution: ./solver.txt");
_JDLV_INVOCATION_Solver.run();
while(_BUFFERED_HANDLER_Solver.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELSolver=_BUFFERED_HANDLER_Solver.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(spostamenti, "sposta",_temporary_JDLV_MODELSolver,Spostamenti.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "spostamenti " + spostamenti.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(spostamenti,0));
}
if(_JDLV_INVOCATION_Solver.haveModel()==false){
if(max< 50 )
{
spostamenti=compute(w,max+ 1 );
}
}
if(!_JDLV_INVOCATION_Solver.getErrors().isEmpty()){
throw new java.lang.RuntimeException(_JDLV_INVOCATION_Solver.getErrors().get(0).getText());
}
}
catch(java.lang.Throwable _JDLV_EXCEPTION_Solver){
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logErrorMessage(_JDLV_EXCEPTION_Solver.getMessage());
}
_JDLV_PROGRAM_Solver.cleanText();

	// ---- END - prepareJDLVCall ---- 
return spostamenti;
}
}


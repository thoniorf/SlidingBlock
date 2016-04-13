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
public Set<Spostamenti> compute(World w){
Point exitPoint=w.getMatrix().getExitCell();
ExitCell exit= new ExitCell(exitPoint.x,exitPoint.y);
Set<Blocco> blocchiDLV= new HashSet<Blocco>();
Set<BKey> bKeyDLV= new HashSet<BKey>();
ArrayList<Block> blocchiJ=w.getBlocks();
Set<Spostamenti> spostamenti= new HashSet<Spostamenti>();
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

	// ---- START - startProgram ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Creation EXECUTING JDLV module.");
it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING=new it.unical.mat.wrapper.DLVInputProgramImpl();
_JDLV_PROGRAM_EXECUTING.cleanText();
java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING=new java.lang.StringBuffer();
it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

	// ---- END - startProgram ---- 

	// ---- START - addInMapping ---- 
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(dim,"dim"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'dim::dim' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(dim,"dim"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'key::key' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(key,"key"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(turno,"turno"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'turno::turno' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(turno,"turno"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(blocchiDLV,"blocco"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'blocchiDLV::blocco' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(blocchiDLV,"blocco"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'bKeyDLV::bKey' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(bKeyDLV,"bKey"), 0));
_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"));
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add in-mapping 'exit::uscita' in module EXECUTING:"+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(it.unical.mat.jdlv.program.TypeSolver.getNameTranslation(exit,"uscita"), 0));

	// ---- END - addInMapping ---- 
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Add out-mapping 'spostamenti::sposta' in module EXECUTING.");

	// ---- START - prepareJDLVCall ---- 
try{

_JDLV_INVOCATION_EXECUTING=it.unical.mat.wrapper.DLVWrapper.getInstance().createInvocation(it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath());
_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING.toString());
_JDLV_PROGRAM_EXECUTING.addText("row(X) :- #int(X), dim(T), X < T."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("col(X) :- #int(X), dim(T), X < T."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("cella(X, Y) :- row(X), col(Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("piena(X, Y) :- cella(X, Y), blocco(_, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(B, X, Y, 0) :- cella(X, Y), blocco(B, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(0, X, Y, 0) :- cella(X, Y), not piena(X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("right(X, Y, X, Y1) :- cella(X, Y), cella(X, Y1), Y1 = Y + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("left(X, Y, X, Y1) :- cella(X, Y), cella(X, Y1), Y1 = Y - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("down(X, Y, X1, Y) :- cella(X, Y), cella(X1, Y), X1 = X + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("up(X, Y, X1, Y) :- cella(X, Y), cella(X1, Y), X1 = X - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("adiacente(X, Y, X1, Y1) :- right(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("adiacente(X, Y, X1, Y1) :- left(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("adiacente(X, Y, X1, Y1) :- down(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("adiacente(X, Y, X1, Y1) :- up(X1, Y1, X, Y)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("posSpostSu(B, B) :- blocco(B, _, _)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("posSpostSu(B, 0) :- blocco(B, _, _)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("totBlockCol(B, T) :- bKey(B, _, _, _), #count{G,X1,Y1 : contiene(G, X1, Y1, 0), G = B} = L, #int(L), T = L - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("sposta(B, X, Y, X1, Y1, T1) v nonSposta(B, X, Y, X1, Y1, T1) :- B > 0, T1 = T + 1, bKey(B, X, Y, T), adiacente(X, Y, X1, Y1), contiene(G, X1, Y1, T), posSpostSu(B, G), turno(T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("spostatiIN(X, Y, T1) :- sposta(_, _, _, X, Y, T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("spostatiDA(B, X, Y, T1) :- sposta(B, X, Y, _, _, T1), not spostatiIN(X, Y, T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(B, X, Y, T) :- sposta(B, _, _, X, Y, T), turno(T)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(0, X, Y, T) :- spostatiDA(B, X, Y, T), turno(T)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(B, X, Y, T1) :- contiene(B, X, Y, T), T1 = T + 1, not spostatiDA(B, X, Y, T1), B > 0, turno(T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("contiene(0, X, Y, T1) :- contiene(0, X, Y, T), T1 = T + 1, not spostatiIN(X, Y, T1), turno(T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("sposta(B, X1, Y1, X2, Y2, T1) :- sposta(B, X, Y, XX, YY, T1), up(X, Y, XX, YY), up(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), T = T1 - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("sposta(B, X1, Y1, X2, Y2, T1) :- sposta(B, X, Y, XX, YY, T1), down(X, Y, XX, YY), down(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), T = T1 - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("sposta(B, X1, Y1, X2, Y2, T1) :- sposta(B, X, Y, XX, YY, T1), right(X, Y, XX, YY), right(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), T = T1 - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("sposta(B, X1, Y1, X2, Y2, T1) :- sposta(B, X, Y, XX, YY, T1), left(X, Y, XX, YY), left(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), T = T1 - 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("bKey(B, X1, Y1, T1) :- T1 = T + 1, bKey(B, X, Y, T), sposta(B, X, Y, X1, Y1, T1), turno(T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("bKey(BB, X, Y, T1) :- T1 = T + 1, bKey(BB, X, Y, T), sposta(B, _, _, _, _, T1), BB != B, turno(T1)."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("celCol(B, X, Y, X1, Y, T) :- bKey(B, X, Y, T), contiene(B, X1, Y, T), X1 != X."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("celCol(B, X, Y, X, Y1, T) :- bKey(B, X, Y, T), contiene(B, X, Y1, T), Y1 != Y."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("celCol(B, X, Y, X1, Y1, T) :- bKey(B, X, Y, T), contiene(B, X1, Y1, T), Y1 != Y, X1 != X."+'\n');
_JDLV_PROGRAM_EXECUTING.addText("turno(T) :- turno(T1), T = T1 + 1, key(K), uscita(N, M), contiene(G, N, M, T1), G != K."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- bKey(B, X, Y, T), sposta(B, X, Y, XX, YY, T1), up(X, Y, XX, YY), #count{G,X1,Y1 : G = B, up(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), contiene(F, X2, Y2, T), posSpostSu(G, F)} = L, #int(L), totBlockCol(B, NUM), L != NUM, T1 = T + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- bKey(B, X, Y, T), sposta(B, X, Y, XX, YY, T1), down(X, Y, XX, YY), #count{G,X1,Y1 : G = B, down(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), contiene(F, X2, Y2, T), posSpostSu(G, F)} = L, #int(L), totBlockCol(B, NUM), L != NUM, T1 = T + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- bKey(B, X, Y, T), sposta(B, X, Y, XX, YY, T1), right(X, Y, XX, YY), #count{G,X1,Y1 : G = B, right(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), contiene(F, X2, Y2, T), posSpostSu(G, F)} = L, #int(L), totBlockCol(B, NUM), L != NUM, T1 = T + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- bKey(B, X, Y, T), sposta(B, X, Y, XX, YY, T1), left(X, Y, XX, YY), #count{G,X1,Y1 : G = B, left(X1, Y1, X2, Y2), celCol(G, X, Y, X1, Y1, T), contiene(F, X2, Y2, T), posSpostSu(G, F)} = L, #int(L), totBlockCol(B, NUM), L != NUM, T1 = T + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- contiene(B, X, Y, T), contiene(A, X, Y, T), B != A."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- sposta(B, X, Y, X1, Y1, T1), sposta(B, X1, Y1, X, Y, T), T = T1 + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- sposta(B, _, _, _, _, T), sposta(B1, _, _, _, _, T), B1 != B."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- sposta(_, _, _, _, _, T1), uscita(N, M), key(K), contiene(G, N, M, T), G = K, T1 = T + 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- sposta(B, X, Y, X1, Y1, T), sposta(B, X, Y, X3, Y3, T), X3 != X1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- sposta(B, X, Y, X1, Y1, T), sposta(B, X, Y, X3, Y3, T), Y3 != Y1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":- not #count{B,T : sposta(B, A, C, X, Y, T), key(B), uscita(X, Y)} = 1."+'\n');
_JDLV_PROGRAM_EXECUTING.addText(":~ turno(T). [T:1]"+'\n');
_JDLV_PROGRAM_EXECUTING.getFiles().clear();
_JDLV_INVOCATION_EXECUTING.addOption(" -N=50");
_JDLV_INVOCATION_EXECUTING.setNumberOfModels(1);
_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING=new it.unical.mat.wrapper.ModelBufferedHandler(_JDLV_INVOCATION_EXECUTING);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Start execution EXECUTING program: executablePath='"+it.unical.mat.jdlv.util.JdlvProperties.getInstance().getDlvExecutablePath()+"', options='"+_JDLV_INVOCATION_EXECUTING.getOptionsString()+"'"+'\n'+"Code execution: "+it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyCode(_JDLV_INVOCATION_EXECUTING.getInputProgram().getCompleteText(),0));
_JDLV_INVOCATION_EXECUTING.run();
while(_BUFFERED_HANDLER_EXECUTING.hasMoreModels()){
it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING=_BUFFERED_HANDLER_EXECUTING.nextModel();
it.unical.mat.jdlv.program.TypeSolver.loadPredicate(spostamenti, "sposta",_temporary_JDLV_MODELEXECUTING,Spostamenti.class);
it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage("Process new answer_set"+ '\n' + "Results:"+ '\n'+ "spostamenti " + spostamenti.size() + " elements"+ '\n' + it.unical.mat.jdlv.program.JDLV_Logger.getInstance().getPrettyObject(spostamenti,0));
}
if(_JDLV_INVOCATION_EXECUTING.haveModel()==false){
System.out.println( "No solution" );
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
return spostamenti;
}
}


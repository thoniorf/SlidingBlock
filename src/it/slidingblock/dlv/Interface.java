package it.slidingblock.dlv;

import it.slidingblock.combinazioni.Adiacenze;
import it.slidingblock.combinazioni.Contiene;
import it.slidingblock.combinazioni.Dimensione;
import it.slidingblock.combinazioni.Pivot;
import it.slidingblock.combinazioni.SpostamentiC;
import it.slidingblock.core.World;
import it.slidingblock.core.block.Block;
import it.slidingblock.core.block.KeyBlock;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Interface {

	public int dim, key = 0;

	public Interface(int dim) {
		this.dim = dim;
	}

	public ArrayList<SpostamentiC> compute(World w, int max) {
		long start = System.currentTimeMillis();
		ArrayList<Point> cell = new ArrayList<Point>();
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++) {
				cell.add(new Point(i, j));
			}
		}
		Set<Adiacenze> adiacenze = new HashSet<Adiacenze>();
		for (int i = 0; i < cell.size(); i++) {
			for (int j = 0; j < cell.size(); j++) {
				if (i != j) {
					int rowI = cell.get(i).y;
					int colI = cell.get(i).x;
					int rowJ = cell.get(j).y;
					int colJ = cell.get(j).x;
					if (rowI == rowJ + 1 && rowJ < dim) {
						adiacenze.add(new Adiacenze(colI, rowI, colJ, rowJ));
						adiacenze.add(new Adiacenze(colJ, rowJ, colI, rowI));
					} else if (colI == colJ + 1 && colJ < dim) {
						adiacenze.add(new Adiacenze(colI, rowI, colJ, rowJ));
						adiacenze.add(new Adiacenze(colJ, rowJ, colI, rowI));
					}
				}
			}
		}
		Point exitPoint = w.getMatrix().getExitCell();
		ExitCell exit = new ExitCell(exitPoint.y, exitPoint.x);
		ArrayList<Block> blocchiJava = w.getBlocks();
		Set<Blocco> blocchiDLV = new HashSet<Blocco>();
		Set<Dimensione> blocchiDim = new HashSet<Dimensione>();
		Set<Pivot> pivot = new HashSet<Pivot>();
		Set<Contiene> contiene = new HashSet<Contiene>();
		Set<Integer> turni = new HashSet<Integer>();
		ArrayList<SpostamentiC> spostamenti = new ArrayList<SpostamentiC>();
		for (Block b : blocchiJava) {
			blocchiDLV.add(new Blocco(b.getId(), b.getWidth(), b.getHeigth()));
			blocchiDim.add(new Dimensione(b.getId(), b.getWidth()
					* b.getHeigth()));
			Point first = w.getMatrix().getFirstPoint(b.getId());
			pivot.add(new Pivot(b.getId(), 0, first.x, first.y));
			for (Point p : w.getMatrix().getPosition(b.getId())) {
				contiene.add(new Contiene(p.y, p.x, b.getId(), 0));
			}
			if (b instanceof KeyBlock)
				key = b.getId();
		}
		for (int i = 1; i < max; i++) {
			turni.add(i);
		}

		// ---- START - startProgram ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Creation EXECUTING JDLV module.");
		it.unical.mat.wrapper.DLVInputProgram _JDLV_PROGRAM_EXECUTING = new it.unical.mat.wrapper.DLVInputProgramImpl();
		_JDLV_PROGRAM_EXECUTING.cleanText();
		java.lang.StringBuffer _JDLV_PROGRAM_BUFFER_EXECUTING = new java.lang.StringBuffer();
		it.unical.mat.wrapper.DLVInvocation _JDLV_INVOCATION_EXECUTING;

		// ---- END - startProgram ----

		// ---- START - addInMapping ----
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(adiacenze, "adiacente"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'adiacenze::adiacente' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(adiacenze,
														"adiacente"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(turni, "turno"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'turni::turno' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(turni,
														"turno"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(key, "key"));
		it.unical.mat.jdlv.program.JDLV_Logger
				.getInstance()
				.logInfoMessage(
						"Add in-mapping 'key::key' in module EXECUTING:"
								+ it.unical.mat.jdlv.program.JDLV_Logger
										.getInstance()
										.getPrettyCode(
												it.unical.mat.jdlv.program.TypeSolver
														.getNameTranslation(
																key, "key"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(blocchiDLV, "blocco"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'blocchiDLV::blocco' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(blocchiDLV,
														"blocco"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(blocchiDim, "dim"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'blocchiDim::dim' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(blocchiDim,
														"dim"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(pivot, "pivot"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'pivot::pivot' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(pivot,
														"pivot"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(contiene, "contiene"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'contiene::contiene' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(contiene,
														"contiene"), 0));
		_JDLV_PROGRAM_EXECUTING.addText(it.unical.mat.jdlv.program.TypeSolver
				.getNameTranslation(exit, "exit"));
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add in-mapping 'exit::exit' in module EXECUTING:"
						+ it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
								.getPrettyCode(
										it.unical.mat.jdlv.program.TypeSolver
												.getNameTranslation(exit,
														"exit"), 0));

		// ---- END - addInMapping ----
		it.unical.mat.jdlv.program.JDLV_Logger.getInstance().logInfoMessage(
				"Add out-mapping 'spostamenti::sposta' in module EXECUTING.");

		// ---- START - prepareJDLVCall ----
		try {

			_JDLV_INVOCATION_EXECUTING = it.unical.mat.wrapper.DLVWrapper
					.getInstance().createInvocation(
							it.unical.mat.jdlv.util.JdlvProperties
									.getInstance().getDlvExecutablePath());
			_JDLV_PROGRAM_EXECUTING.addText(_JDLV_PROGRAM_BUFFER_EXECUTING
					.toString());
			_JDLV_PROGRAM_EXECUTING.getFiles().clear();
			_JDLV_PROGRAM_EXECUTING.addFile("./combinazioni.dlv");
			_JDLV_INVOCATION_EXECUTING.addOption("-n=1, -N=" + max);
			_JDLV_INVOCATION_EXECUTING.setNumberOfModels(1);
			_JDLV_PROGRAM_BUFFER_EXECUTING.append("");
			_JDLV_INVOCATION_EXECUTING.setInputProgram(_JDLV_PROGRAM_EXECUTING);
			it.unical.mat.wrapper.ModelBufferedHandler _BUFFERED_HANDLER_EXECUTING = new it.unical.mat.wrapper.ModelBufferedHandler(
					_JDLV_INVOCATION_EXECUTING);
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
					.logInfoMessage(
							"Start execution EXECUTING program: executablePath='"
									+ it.unical.mat.jdlv.util.JdlvProperties
											.getInstance()
											.getDlvExecutablePath()
									+ "', options='"
									+ _JDLV_INVOCATION_EXECUTING
											.getOptionsString()
									+ "'"
									+ '\n'
									+ "Code execution: "
									+ it.unical.mat.jdlv.program.JDLV_Logger
											.getInstance().getPrettyCode(
													_JDLV_INVOCATION_EXECUTING
															.getInputProgram()
															.getCompleteText(),
													0) + '\n'
									+ "Files execution: ./combinazioni.dlv");
			_JDLV_INVOCATION_EXECUTING.run();
			while (_BUFFERED_HANDLER_EXECUTING.hasMoreModels()) {
				it.unical.mat.wrapper.Model _temporary_JDLV_MODELEXECUTING = _BUFFERED_HANDLER_EXECUTING
						.nextModel();
				it.unical.mat.jdlv.program.TypeSolver.loadPredicate(
						spostamenti, "sposta", _temporary_JDLV_MODELEXECUTING,
						SpostamentiC.class);
				it.unical.mat.jdlv.program.JDLV_Logger
						.getInstance()
						.logInfoMessage(
								"Process new answer_set"
										+ '\n'
										+ "Results:"
										+ '\n'
										+ "spostamenti "
										+ spostamenti.size()
										+ " elements"
										+ '\n'
										+ it.unical.mat.jdlv.program.JDLV_Logger
												.getInstance().getPrettyObject(
														spostamenti, 0));
			}
			if (_JDLV_INVOCATION_EXECUTING.haveModel() == false) {
				System.out.println("Niente");
				spostamenti = compute(w, max + 1);
			}
			if (!_JDLV_INVOCATION_EXECUTING.getErrors().isEmpty()) {
				throw new java.lang.RuntimeException(_JDLV_INVOCATION_EXECUTING
						.getErrors().get(0).getText());
			}
		} catch (java.lang.Throwable _JDLV_EXCEPTION_EXECUTING) {
			it.unical.mat.jdlv.program.JDLV_Logger.getInstance()
					.logErrorMessage(_JDLV_EXCEPTION_EXECUTING.getMessage());
		}
		_JDLV_PROGRAM_EXECUTING.cleanText();

		// ---- END - prepareJDLVCall ----
		System.out.println("Tempo: "
				+ (int) (System.currentTimeMillis() - start));
		return spostamenti;
	}
}

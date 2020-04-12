package org.pdfsam.merge;


import java.util.ArrayList;
import org.sejda.model.input.PdfMergeInput;
import java.util.Set;
import org.sejda.model.pdf.page.PageRange;

public class MergeParametersBuilderProduct {
	private ArrayList<PdfMergeInput> inputs = new ArrayList<>();

	public ArrayList<PdfMergeInput> getInputs() {
		return inputs;
	}

	public void addInputlvl2(PdfMergeInput input, int pagenumber) {
		PdfMergeInput newInput = new PdfMergeInput(input.getSource(), Set.of(new PageRange(pagenumber, pagenumber)));
		this.inputs.add(newInput);
	}

	public boolean hasInput() {
		return !inputs.isEmpty();
	}

	public void addInputRefactored(PdfMergeInput input, PageRange pagerange) {
		for (int pagenumber : pagerange.getPages(pagerange.getEnd())) {
			addInputlvl2(input, pagenumber);
		}
	}

	public void addInput(PdfMergeInput input) {
		for (PageRange pagerange : input.getPageSelection()) {
			addInputRefactored(input, pagerange);
		}
	}
}
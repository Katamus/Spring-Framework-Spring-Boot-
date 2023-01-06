package com.bolsadeideas.springboot.app.view.pdf;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.bolsadeideas.springboot.app.models.entity.Factura;
import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component("factura/ver")
public class FacturaPdfView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		Factura factura = (Factura) model.get("factura");
		
		PdfPTable table = new PdfPTable(1);
		table.setSpacingAfter(20);
		table.addCell("Datos del Cliente");
		table.addCell(factura.getCliente().getNombre() + " " + factura.getCliente().getApellido());
		table.addCell(factura.getCliente().getEmail());
		
		PdfPTable table2 = new PdfPTable(1);
		table2.setSpacingAfter(20);
		table2.addCell("Datos de la Factura");
		table2.addCell("Folio: "+ factura.getId());
		table2.addCell("Descripción: "+ factura.getDescripcion());
		table2.addCell("Fecha: "+ factura.getCreateAt());
		
		document.add(table);
		document.add(table2);
	}

}

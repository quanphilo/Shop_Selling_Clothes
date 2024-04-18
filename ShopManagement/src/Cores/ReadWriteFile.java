package Cores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;

import javax.swing.JFileChooser;

import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;

public class ReadWriteFile {
	private Vector<Object> listObject;

	public ReadWriteFile(Vector<Object> listObject) {
		super();
		this.listObject = listObject;
	}

	public ReadWriteFile() {
		super();
	}

	public int writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header) {
		int kq = 0;
		JFileChooser chooser = new JFileChooser();
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			try {

				BufferedWriter bwrite = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(file + ".xls"), StandardCharsets.UTF_8));
				// ten Cot
				for (String column : header) {
					bwrite.write(column + "\t");
				}
				bwrite.write("\n");
				// Lay du lieu dong
				for (Vector<String> object : listObjectData) {
					for (String data : object) {
						bwrite.write(data + "\t");
					}
					bwrite.write("\n");
				}

				bwrite.close();
				kq = 1;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kq;
	}

	public File writeExcel(Vector<Vector<String>> listObjectData, Vector<String> header, int flag) {
		int kq = 0;
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			try {

				BufferedWriter bwrite = new BufferedWriter(
						new OutputStreamWriter(new FileOutputStream(file + ".xls"), StandardCharsets.UTF_8));
				// ten Cot
				for (String column : header) {
					bwrite.write(column + "\t");
				}
				bwrite.write("\n");
				// Lay du lieu dong
				for (Vector<String> object : listObjectData) {
					for (String data : object) {
						bwrite.write(data + "\t");
					}
					bwrite.write("\n");
				}

				bwrite.close();
				kq = 1;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return file;
	}

	public int writeExcelForDetail(Vector<Vector<String>> listObjectData, Vector<String> header, File file) {
		int kq = 0;
		try {

			BufferedWriter bwrite = new BufferedWriter(
					new OutputStreamWriter(
							new FileOutputStream(file + "_" + listObjectData.get(0).get(0) + "-chitiet" + ".xlsx"),
							StandardCharsets.UTF_8));
			// ten Cot
			for (String column : header) {
				bwrite.write(column + "\t");
			}
			bwrite.write("\n");
			// Lay du lieu dong
			for (Vector<String> object : listObjectData) {
				for (String data : object) {
					bwrite.write(data + "\t");
				}
				bwrite.write("\n");
			}

			bwrite.close();
			kq = 1;
		} catch (Exception e2) {
			e2.printStackTrace();
		}
		return kq;
	}

	public int writeChart(JFreeChart chart) {
		int kq = 0;
		JFileChooser chooser = new JFileChooser();
		File file = null;
		int i = chooser.showSaveDialog(chooser);
		if (i == JFileChooser.APPROVE_OPTION) {
			file = chooser.getSelectedFile();
			try {
				ChartUtils.saveChartAsPNG(new File(file + ".png"), chart, 1200, 650);
				kq = 1;
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return kq;
	}
}

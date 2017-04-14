package myhome;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

public class ImageTest {
	
	public static File readFile(String path){
		System.out.println("读取图片......");
		File file = new File(path);
		if(!file.exists()){
			file.mkdir();
		}
		return file;
	}
	
	public static Builder<File> processImage(File file){
		System.out.println("压缩处理图片......");
		Builder<File> builderFile = Thumbnails.of(file);
		builderFile.scale(0.3);
//		builderFile.sourceRegion(Positions.CENTER, 500, 500);
//		builderFile.size(600, 500).outputQuality(0.8);
//		builderFile.keepAspectRatio(true);
		return builderFile;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println("处理图片开始......");
			processImage(readFile("D://232.jpg")).toFiles(readFile("D://outImage"), Rename.NO_CHANGE);
			System.out.println("处理图片结束......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("处理图片error......");
			e.printStackTrace();
		};
	}

}

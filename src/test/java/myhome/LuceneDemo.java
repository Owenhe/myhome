/**  
 * @Title: LuceneDemo.java
 * @Package myhome
 *
 */ 
package myhome;

import java.io.IOException;
import java.nio.file.Paths;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.StringField;
import org.apache.lucene.document.TextField;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

/**
 * @ClassName: LuceneDemo
 * @Description: TODO
 * @author yi.he
 * @date Nov 9, 2016 10:04:56 AM
 *
 */
public class LuceneDemo {

	 public static String[] strs = {  
	            "Mybatis分页插件 - 示例",  
	            "Mybatis 贴吧问答 第一期",  
	            "Mybatis 示例之 复杂(complex)属性(property)",  
	            "Mybatis极其(最)简(好)单(用)的一个分页插件",  
	            "Mybatis 的Log4j日志输出问题 - 以及有关日志的所有问题",  
	            "Mybatis 示例之 foreach （下）",  
	            "Mybatis 示例之 foreach （上）",  
	            "Mybatis 示例之 SelectKey",  
	            "Mybatis 示例之 Association (2)",  
	            "Mybatis 示例之 Association",  
	            "Mybatis API",
	            "Mybatis 最新的BUG"
	        };  
	 public static String indexDir = "d:/LuceneIndex";

	/**
	 * 
	 */
	public LuceneDemo() {
		// TODO Auto-generated constructor stub
	}

	/** 
	 * @Description: TODO
	 * @param args
	 */
	public static void main(String[] args) {
		writerIndex();
		readerIndex();
	}

	public static void readerIndex(){
        Directory dir = null;
        IndexReader reader = null;
		try {
			Analyzer a = new StandardAnalyzer();
			dir = FSDirectory.open(Paths.get(indexDir));
			reader = DirectoryReader.open(dir);
			IndexSearcher is = new IndexSearcher(reader);
			QueryParser parser = new QueryParser("info", a);
			Query query = parser.parse("Mybatis");
			TopDocs topDocs = is.search(query, 100);
			System.out.println("总共匹配多少个：" + topDocs.totalHits);
			ScoreDoc[] hits = topDocs.scoreDocs;
			// 应该与topDocs.totalHits相同
			System.out.println("多少条数据：" + hits.length);
			for (ScoreDoc scoreDoc : hits) {
				System.out.println("匹配得分：" + scoreDoc.score);
				System.out.println("文档索引ID：" + scoreDoc.doc);
				Document document = is.doc(scoreDoc.doc);
				System.out.println(document.get("info"));
				System.out.println(document.get("isb"));
			}
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				reader.close();
				dir.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static void writerIndex(){
		Directory dir = openFSDirectory() ;
		IndexWriter iw = getIndexWriter(dir) ;
		try {
			removeAllIndex(iw);
			writerIndex(iw);
			closeIndexWriter(iw);
			closeDirectory(dir);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Directory openFSDirectory(){
		Directory dir = null;
		try {
			dir = FSDirectory.open(Paths.get(indexDir));
			dir.obtainLock(IndexWriter.WRITE_LOCK_NAME).close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dir;
	}
	
	public static void closeDirectory(Directory directory) throws IOException {
		if (null != directory) {
			directory.close();
			directory = null;
		}
	}
	
	public static void closeIndexWriter(IndexWriter indexWriter) throws IOException {
		if (null != indexWriter) {
			indexWriter.close();
			indexWriter = null;
		}
	}
	
	public static IndexWriter getIndexWriter(Directory directory){
		IndexWriter iw = null;
		try {
			Analyzer analyzer = new StandardAnalyzer();
			IndexWriterConfig iwc = new IndexWriterConfig(analyzer);
			iw = new IndexWriter(directory, iwc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return iw;
	}
	
	public static void writerIndex(IndexWriter indexWriter) throws IOException{
		for (String str : strs) {
			Document doc = new Document();
			doc.add(new TextField("info", str, Store.YES));
			doc.add(new StringField("isb", Math.random() + "", Store.YES));
			indexWriter.addDocument(doc);
		}
	}
	
	public static void removeAllIndex(IndexWriter indexWriter){
		try {
			indexWriter.deleteAll();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

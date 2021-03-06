/*
 * OpenFileTable.java
 * 
 * Copyright 2016 Emmanuel <emmanuel.salcido.maldonado@gmail.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
import java.util.*;

public class OpenFileTable{
	
	public static OpenFileTable table;
	private ArrayList<MFile> openFiles;
	
	private OpenFileTable(){}
	
	public static OpenFileTable getTable(){
		if(table == null){
			table = new OpenFileTable();
		}
		return table;
	}
	
	public void addFile(MFile file){
		if(openFiles == null){
			openFiles = new ArrayList<MFile>();
		}
		this.openFiles.add(file);
	}
	
	public void deleteFile(String fileName){
		MFile file = getFile(fileName);
		openFiles.remove(file);
	}
	
	public MFile getFile(String fileName){
		//the name of the file need to have the extention. NOT the path
		for(MFile file : openFiles){
			if(file.getName().equals(fileName)){
				return file;
			}
		}
		return null;
	}
}


/*
 * The MIT License
 * 
 * Copyright (c) 2017-2020, Nanten Cloud LLC. Junhong Chen
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.gogbuy.stapler.demo;

import java.util.HashMap;
import java.util.Map;

import org.kohsuke.stapler.StaplerFallback;

import com.gogbuy.stapler.demo.item.Book;
import com.gogbuy.stapler.demo.item.CD;
import com.gogbuy.stapler.demo.item.DefaultItem;
import com.gogbuy.stapler.demo.item.Item;
import com.gogbuy.stapler.demo.item.Painting;

/**
 * The root object serving the root URL /
 * @author junho.chen@outlook.com
 *
 */
public class BookStore implements StaplerFallback {

	/**
	 * Stores various objects scoped to {@link BookStore}
	 */
	public static BookStore theStore = new BookStore();

	public String getMyString() {
		return "Hello, Stapler Jelly!";
	}

	public String getNoJelly() {
		return "getNoJelly";
	}

	public String doNoJelly() {
		return "There's no jelly associated with this doNoJelly() method";
	}

	public Map<String, Item> getItems() {
		Map<String, Item> items = new HashMap<String, Item>();
		items.put("book", new Book("Brave heart"));
		items.put("cd", new CD("Mozart"));
		items.put("painting", new Painting("Monet",985000));
		return items;
	}

	/**
	 * Polymorphism and parameter test.
	 * @param name
	 * @return
	 */
	public Item getItem(String name) {
		if(name == null || name.equals("")) {
			return new Book("The Chaos Classics");
		}
		if("painting".equals(name)) {
			return new Painting("Monet - "+name,985555);
		}
		if(name.startsWith("b")) {
			return new Book(name);
		}
		return new CD(name);
	}

	@Override
	public Object getStaplerFallback() {
		// TODO Auto-generated method stub
		return new DefaultItem();
	}
}

/**
 * Licensed to MKS Group under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * MKS Group licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a
 * copy of the License at:
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package mks.platform.samplewebapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import mks.platform.samplewebapp.common.model.TableStructure;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/handsontable")
public class HansontableController extends BaseController {
	@Value("${productList.colHeaders}")
	private String[] productListColHeaders;
	
	@Value("${productList.colWidths}")
	private int[] productListColWidths;

	@GetMapping(value = "")
	public ModelAndView displayHome(HttpServletRequest request, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("handsontable");

		return mav;
	}
	
	@GetMapping(value = {"loaddata"}, produces="application/json")
	@ResponseBody
    public TableStructure getProductTableData() {
		List<Object[]> lstProducts = getDemoData();

		TableStructure productTable = new TableStructure(productListColWidths, productListColHeaders, lstProducts);
				
        return productTable;
    }

	@PostMapping(value = "/save")
	public String processSave(@RequestBody List<Object[]> tableData) {
		ModelAndView mav = new ModelAndView("handsontable");
		
		return null;
	}
    
	private List<Object[]> getDemoData() {
		List<Object[]> data = new ArrayList<Object[]>();
		
		data.add(new Object[] {"Adjustable Race", "AR-5381", "Blue" });
		data.add(new Object[] {"Bearing Ball", "BA-8327", "Black" });
		
		return data;
	}
}

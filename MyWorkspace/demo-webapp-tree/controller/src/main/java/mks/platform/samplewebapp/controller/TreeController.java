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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class TreeController extends BaseController {
 
	/**
	 * Simply selects the home view to render by returning its name.
     * @return 
	 */
	@GetMapping(value = "/tree")
	public ModelAndView displayHome(HttpServletRequest request, HttpSession httpSession) {
		ModelAndView mav = new ModelAndView("tree");

		return mav;
	}
	
    /**
     * Process ajax request from Tree of Question Pools from client.
     * @return json format of Node
     * @see https://www.jstree.com/docs/json/
     * 
     */
    @GetMapping(value = "/getNodeRoot")
    @ResponseBody
    public String getNodeRoot(@RequestParam("id") Long id) {
        String jsonTree = "{"
        		+ "    \"id\": 0,"
        		+ "    \"text\": \"Root\","
        		+ "    \"a_attr\": {},"
        		+ "    \"state\": {"
        		+ "        \"opened\": true"
        		+ "    },"
        		+ "    \"children\": ["
        		+ "        {"
        		+ "            \"id\": 1,"
        		+ "            \"parent\": 0,"
        		+ "            \"text\": \"Child #1\","
        		+ "            \"a_attr\": {"
        		+ "                \"description\": \"\","
        		+ "                \"title\": \"Children #1\""
        		+ "            },"
        		+ "            \"state\": {},"
        		+ "            \"children\": ["
        		+ "                {"
        		+ "                    \"id\": 2,"
        		+ "                    \"parent\": 1,"
        		+ "                    \"text\": \"Child #1.1\","
        		+ "                    \"a_attr\": {"
        		+ "                        \"description\": \"\","
        		+ "                        \"title\": \"Children #1.1\""
        		+ "                    },"
        		+ "                    \"state\": {}"
        		+ ""
        		+ "                }"
        		+ "            ]"
        		+ "        },"
        		+ "{"
        		+ "            \"id\": 4,"
        		+ "            \"parent\": 0,"
        		+ "            \"text\": \"Child #2\","
        		+ "            \"a_attr\": {"
        		+ "                \"description\": \"\","
        		+ "                \"title\": \"Children #2\""
        		+ "            },"
        		+ "            \"state\": {},"
        		+ "            \"children\": ["
        		+ "                {"
        		+ "                    \"id\": 5,"
        		+ "                    \"parent\": 1,"
        		+ "                    \"text\": \"Child #2.1\","
        		+ "                    \"a_attr\": {"
        		+ "                        \"description\": \"\","
        		+ "                        \"title\": \"Children #2.1\""
        		+ "                    },"
        		+ "                    \"state\": {}"
        		+ ""
        		+ "                }"
        		+ "            ]"
        		+ "        }"
        		+ "    ]"
        		+ "}";
        
        return jsonTree;
        
    }
    
    /**
     * Process ajax request from Tree of Question Pools to load sub Pools.
     * 
     * @param id Identifier of the Question Pool.
     * @return json data of sub pools.
     */
    @GetMapping(value = "/getNodeChildren")
    @ResponseBody
    public String getNodeChildren(@RequestParam("id") Long id) {
    	return "Child" + id;
    }
}

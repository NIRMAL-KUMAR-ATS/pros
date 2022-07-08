package com.userprofile.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.userprofile.entity.UserProfile;
import com.userprofile.service.UserProfileService;

@Controller
public class UserController {

	@Value("${uploadDir}")
	private String uploadFolder;

	@Autowired
	private UserProfileService userProfileService;

	@GetMapping(value = { "/", "/home" })
	public String addProductPage() {

		return "index";

	}

	@PostMapping("/image/saveImageDetails")
	public @ResponseBody ResponseEntity<?> createProduct(
			//@RequestBody String nameofuser,
			@RequestParam("userProfileName") String userProfileName,
			//@RequestBody String age,
			@RequestParam("age") String age,
			//@RequestBody String dob,
			@RequestParam("dob") String dob,
			//@RequestBody String height,
			@RequestParam("height") String height,
			//@RequestBody String city,
			@RequestParam("city") String city,
			//@RequestBody String education,
			@RequestParam("education") String education,
			//@RequestBody String occupation,
			@RequestParam("occupation") String occupation,
			//@RequestBody String languages,
			@RequestParam("languages") String languages,
			//@RequestBody String performance,
			@RequestParam("performance") String performance,
			//@RequestBody String gendre,
			@RequestParam("gendre") String gendre,
			//@RequestBody String hobbies,
			@RequestParam("hobbies") String hobbies,
			//@RequestBody String drinker,
			@RequestParam("drinker") String drinker,
			//@RequestBody String smoker,
			@RequestParam("smoker") String smoker,
			//@RequestBody String location
			@RequestParam("location") String location
			, Model model,
			HttpServletRequest request, final @RequestParam("image") MultipartFile file) {
		try {
			String uploadDirectory = request.getServletContext().getRealPath(uploadFolder);
			String fileName = file.getOriginalFilename();
			String filePath = Paths.get(uploadDirectory, fileName).toString();
			if (fileName == null || fileName.contains("..")) {

				model.addAttribute("invalid", "Sorry! Invalid path sequence \" + fileName");
				return new ResponseEntity<>("Sorry! Invalid path sequence " + fileName, HttpStatus.BAD_REQUEST);
			}
			
			String[] userProfileNames = userProfileName.split(",");
			String[] ages = age.split(",");
			String[] dobs = dob.split(",");
			String[] heights = height.split(",");
			String[] citys = city.split(",");
			String[] educations = education.split(",");
			String[] occupations = occupation.split(",");
			String[] languagess = languages.split(",");
			String[] performances = performance.split(",");
			String[] gendres = gendre.split(",");
			String[] hobbiess = hobbies.split(",");
			String[] drinkers = drinker.split(",");
			String[] smokers = smoker.split(",");
			String[] locations = location.split(",");
			
			try {
				File dir = new File(uploadDirectory);
				if (!dir.exists()) {
					dir.mkdirs();
				}

				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
				stream.write(file.getBytes());
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

			byte[] imageData = file.getBytes();
			UserProfile userProfile = new UserProfile();
			userProfile.setAge(ages[0]);
			userProfile.setCity(citys[0]);
			userProfile.setDob(dobs[0]);
			userProfile.setDrinker(drinkers[0]);
			userProfile.setEducation(educations[0]);
			userProfile.setGendre(gendres[0]);
			userProfile.setHeight(heights[0]);
			userProfile.setHobbies(hobbiess[0]);
			userProfile.setLanguages(languagess[0]);
			userProfile.setLocation(locations[0]);
			userProfile.setOccupation(occupations[0]);
			userProfile.setPerformance(performances[0]);
			userProfile.setSmoker(smokers[0]);
			userProfile.setUserProfileName(userProfileNames[0]);
			userProfileService.saveImage(userProfile);
			return new ResponseEntity<>("User Information Saved With File - " + fileName, HttpStatus.OK);
		} 
		catch (Exception e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		
		}
	}

	@GetMapping("/image/display/{id}")
	@ResponseBody
	void showImage(@PathVariable("id") Long id, HttpServletResponse response, Optional<UserProfile> imageGallery)
			throws ServletException, IOException {
		imageGallery = userProfileService.getImageById(id);
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		response.getOutputStream().write(imageGallery.get().getImage());
		response.getOutputStream().close();
	}

	@GetMapping("/image/imageDetails")
	String showProductDetails(@RequestParam("id") Long id, Optional<UserProfile> imageGallery, Model model) {
		try {
			if (id != 0) {
				imageGallery = userProfileService.getImageById(id);

				if (imageGallery.isPresent()) {
					model.addAttribute("id", imageGallery.get());
					model.addAttribute("userProfileName", imageGallery.get().getUserProfileName());
					model.addAttribute("age", imageGallery.get().getAge());
					model.addAttribute("dob", imageGallery.get().getDob());
					model.addAttribute("height", imageGallery.get().getHeight());
					model.addAttribute("city", imageGallery.get().getCity());
					model.addAttribute("education", imageGallery.get().getEducation());
					model.addAttribute("occupation", imageGallery.get().getOccupation());
					model.addAttribute("languages", imageGallery.get().getLanguages());
					model.addAttribute("performance", imageGallery.get().getPerformance());
					model.addAttribute("gendre", imageGallery.get().getGendre());
					model.addAttribute("hobbies", imageGallery.get().getHobbies());
					model.addAttribute("drinker", imageGallery.get().getDrinker());
					model.addAttribute("smoker", imageGallery.get().getSmoker());
					model.addAttribute("location", imageGallery.get().getLocation());
					return "imagedetails";
				}
				return "redirect:/home";
			}
			return "redirect:/home";

		} catch (Exception e) {
			e.printStackTrace();
			return "redirect:/home";
		}
	}

	@GetMapping("/image/show")
	public String show(Model map) {
		List<UserProfile> images = userProfileService.getAllActiveImages();
		map.addAttribute("images", images);
		return "images";
	}

	@GetMapping("/deleteUser")
	public String deleteUser(@RequestParam Long id) {
		userProfileService.deleteUser(id);
		return "redirect:/image/show";
	}

	@PutMapping("/updateUser")
	public String updateUser(@RequestParam Long id) {
		userProfileService.updateUser(id);
		return "redirect:/image/show";
	}
}

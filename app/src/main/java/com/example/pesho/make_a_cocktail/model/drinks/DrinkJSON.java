package com.example.pesho.make_a_cocktail.model.drinks;

import org.json.JSONArray;

/**
 * Created by Pesho on 9/13/2016.
 */
public class DrinkJSON {
    public static String drinks = "[\n" +
            "    {\n" +
            "      \"idDrink\":\"13060\",\n" +
            "      \"strDrink\":\"Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Rub rim of cocktail glass with lime juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve.\",\n" +
            "      \"strDrinkThumb\":\"http:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/wpxpvu1439905379.jpg\",\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Triple sec\",\n" +
            "      \"strIngredient3\":\"Lime juice\",\n" +
            "      \"strIngredient4\":\"Salt\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1\\/2 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"\\n\",\n" +
            "      \"strMeasure5\":\"\\n\",\n" +
            "      \"strMeasure6\":\"\\n\",\n" +
            "      \"strMeasure7\":\"\\n\",\n" +
            "      \"strMeasure8\":\"\\n\",\n" +
            "      \"strMeasure9\":\"\\n\",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":\"2015-08-18 14:42:59\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"11718\",\n" +
            "      \"strDrink\":\"Margarita #2\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Rub rim of margarita glass with lemon juice, dip rim in salt. Shake all ingredients with ice, strain into the salt-rimmed glass, and serve. (See also Frozen Margarita.)\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Triple sec\",\n" +
            "      \"strIngredient3\":\"Lemon juice\",\n" +
            "      \"strIngredient4\":\"Salt\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1\\/2 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"\\n\",\n" +
            "      \"strMeasure5\":\"\\n\",\n" +
            "      \"strMeasure6\":\"\\n\",\n" +
            "      \"strMeasure7\":\"\\n\",\n" +
            "      \"strMeasure8\":\"\\n\",\n" +
            "      \"strMeasure9\":\"\\n\",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"11118\",\n" +
            "      \"strDrink\":\"Blue Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Rub rim of cocktail glass with lime juice. Dip rim in coarse salt. Shake tequila, blue curacao, and lime juice with ice, strain into the salt-rimmed glass, and serve.\",\n" +
            "      \"strDrinkThumb\":\"http:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/qtvvyq1439905913.jpg\",\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Blue Curacao\",\n" +
            "      \"strIngredient3\":\"Lime juice\",\n" +
            "      \"strIngredient4\":\"Salt\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"Coarse \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":\"2015-08-18 14:51:53\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14460\",\n" +
            "      \"strDrink\":\"Peach Margarita\",\n" +
            "      \"strCategory\":\"Cocktail\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Pour tequila, peach schnapps, and sweet & sour over ice. Add grenadine and stir slightly. The drink should fade from yellow to red. You can also put ingredients in a blender with ice for a frozen version.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Peach schnapps\",\n" +
            "      \"strIngredient3\":\"Sweet and sour\",\n" +
            "      \"strIngredient4\":\"Grenadine\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"dash \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"15679\",\n" +
            "      \"strDrink\":\"Midori Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Moisten rim of cocktail glass with lime juice and dip in salt. Shake ingredients together, and pour into glass filled with crushed ice. Option: Mix above ingredients with one cup of ice in blender for a smooth, \\\"granita\\\" type drink.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Triple sec\",\n" +
            "      \"strIngredient3\":\"Lime juice\",\n" +
            "      \"strIngredient4\":\"Midori melon liqueur\",\n" +
            "      \"strIngredient5\":\"Salt\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1\\/2 oz \",\n" +
            "      \"strMeasure3\":\"1 oz fresh \",\n" +
            "      \"strMeasure4\":\"1\\/2 oz \",\n" +
            "      \"strMeasure5\":\"\\n\",\n" +
            "      \"strMeasure6\":\"\\n\",\n" +
            "      \"strMeasure7\":\"\\n\",\n" +
            "      \"strMeasure8\":\"\\n\",\n" +
            "      \"strMeasure9\":\"\\n\",\n" +
            "      \"strMeasure10\":\"\\n\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"15651\",\n" +
            "      \"strDrink\":\"Mansion Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Mix above ingredients in a shaker. Shake and serve on the rocks.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Gold tequila\",\n" +
            "      \"strIngredient2\":\"Grand Marnier\",\n" +
            "      \"strIngredient3\":\"Cointreau\",\n" +
            "      \"strIngredient4\":\"Sweet and sour\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/4 oz \",\n" +
            "      \"strMeasure2\":\"3\\/4 oz \",\n" +
            "      \"strMeasure3\":\"3\\/4 oz \",\n" +
            "      \"strMeasure4\":\"1 1\\/4 oz \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"13799\",\n" +
            "      \"strDrink\":\"JimPop's Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Lightly rub the rim of a cocktail glass with some lime juice, dip glass rim in the salt. Mix all ingredients with ice, strain into fresh ice in the salt-rimmed glass, and enjoy!\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Lime juice\",\n" +
            "      \"strIngredient3\":\"Grand Marnier\",\n" +
            "      \"strIngredient4\":\"Salt\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"2 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"3\\/4 oz \",\n" +
            "      \"strMeasure4\":\"\\n\",\n" +
            "      \"strMeasure5\":\"\\n\",\n" +
            "      \"strMeasure6\":\"\\n\",\n" +
            "      \"strMeasure7\":\"\\n\",\n" +
            "      \"strMeasure8\":\"\\n\",\n" +
            "      \"strMeasure9\":\"\\n\",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14009\",\n" +
            "      \"strDrink\":\"Catalina Margarita\",\n" +
            "      \"strCategory\":\"Cocktail\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Shake with cracked ice and strain into chilled cocktail or margarita glass.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Peach schnapps\",\n" +
            "      \"strIngredient3\":\"Blue Curacao\",\n" +
            "      \"strIngredient4\":\"Sour mix\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"4 oz \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14462\",\n" +
            "      \"strDrink\":\"Ultimate Margarita\",\n" +
            "      \"strCategory\":\"Cocktail\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Pour tequila, Cointreau, and sweet & sour over crushed ice. Add lime juice. Can be made frozen by putting in a blender with 3 cups ice.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Cointreau\",\n" +
            "      \"strIngredient3\":\"Sweet and sour\",\n" +
            "      \"strIngredient4\":\"Lime\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"1 oz \",\n" +
            "      \"strMeasure4\":\"Juice of 1\\/4 \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"16158\",\n" +
            "      \"strDrink\":\"Whitecap Margarita\",\n" +
            "      \"strCategory\":\"Other\\/Unknown\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Place all ingredients in a blender and blend until smooth. This makes one drink.\",\n" +
            "      \"strDrinkThumb\":\"http:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/srpxxp1441209622.jpg\",\n" +
            "      \"strIngredient1\":\"Ice\",\n" +
            "      \"strIngredient2\":\"Tequila\",\n" +
            "      \"strIngredient3\":\"Cream of coconut\",\n" +
            "      \"strIngredient4\":\"Lime juice\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 cup \",\n" +
            "      \"strMeasure2\":\"2 oz \",\n" +
            "      \"strMeasure3\":\"1\\/4 cup \",\n" +
            "      \"strMeasure4\":\"3 tblsp fresh \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":\"2015-09-02 17:00:22\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"11388\",\n" +
            "      \"strDrink\":\"Frozen Margarita #1\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Place salt in a saucer. Rub rim of a cocktail glass with lime wedge and dip glass into salt to coat rim thoroughly, reserve lime. Pour tequila, triple sec, lime juice, and crushed ice into a blender. Blend well at high speed. Pour into a cocktail glass.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Salt\",\n" +
            "      \"strIngredient2\":\"Lime\",\n" +
            "      \"strIngredient3\":\"Tequila\",\n" +
            "      \"strIngredient4\":\"Triple sec\",\n" +
            "      \"strIngredient5\":\"Lime juice\",\n" +
            "      \"strIngredient6\":\"Ice\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"2 tsp coarse \",\n" +
            "      \"strMeasure2\":\"1 \",\n" +
            "      \"strMeasure3\":\"3 oz white \",\n" +
            "      \"strMeasure4\":\"1 oz \",\n" +
            "      \"strMeasure5\":\"2 oz \",\n" +
            "      \"strMeasure6\":\"1 cup crushed \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\" \",\n" +
            "      \"strMeasure11\":\" \",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"13691\",\n" +
            "      \"strDrink\":\"Frozen Margarita #2\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"vote\",\n" +
            "      \"strInstructions\":\"In blender add the can of limeaide. Using the empty can measure the tequila and the triple sec and add to the blender. Blend, adding ice cubes until the drink becomes slushy and holds in peaks. Serves: 4\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Limeade\",\n" +
            "      \"strIngredient2\":\"Tequila\",\n" +
            "      \"strIngredient3\":\"Triple sec\",\n" +
            "      \"strIngredient4\":\"\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"4 oz \",\n" +
            "      \"strMeasure2\":\"4 oz \",\n" +
            "      \"strMeasure3\":\"1\\/3 can \",\n" +
            "      \"strMeasure4\":\" \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\"\",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14334\",\n" +
            "      \"strDrink\":\"Top Shelf Margarita\",\n" +
            "      \"strCategory\":\"Cocktail\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Fill mixing glass with ice Pour in all ingredients Shake well Pour into salt rimmed glass Add lime wedge or wheel\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Cointreau\",\n" +
            "      \"strIngredient2\":\"Grand Marnier\",\n" +
            "      \"strIngredient3\":\"Sweet and sour\",\n" +
            "      \"strIngredient4\":\"Lime juice\",\n" +
            "      \"strIngredient5\":\"Tequila\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1\\/2 oz \",\n" +
            "      \"strMeasure3\":\"2 1\\/2 oz \",\n" +
            "      \"strMeasure4\":\"1 oz \",\n" +
            "      \"strMeasure5\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\" \",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"15076\",\n" +
            "      \"strDrink\":\"BlackJack Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Fill glass with ice. Add with Tequila, Triple Sec, and Chambord. Then add the Lime juice or sour mix. Shake. Garnish with a lime wedge and serve.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Triple sec\",\n" +
            "      \"strIngredient3\":\"Chambord raspberry liqueur\",\n" +
            "      \"strIngredient4\":\"Lime juice\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1\\/2 oz \",\n" +
            "      \"strMeasure3\":\"1\\/2 oz \",\n" +
            "      \"strMeasure4\":\"4 oz \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"12322\",\n" +
            "      \"strDrink\":\"Strawberry Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Cocktail glass\",\n" +
            "      \"strInstructions\":\"Rub rim of cocktail glass with lemon juice and dip rim in salt. Shake schnapps, tequila, triple sec, lemon juice, and strawberries with ice, strain into the salt-rimmed glass, and serve.\",\n" +
            "      \"strDrinkThumb\":\"http:\\/\\/www.thecocktaildb.com\\/images\\/media\\/drink\\/tqyrpw1439905311.jpg\",\n" +
            "      \"strIngredient1\":\"Strawberry schnapps\",\n" +
            "      \"strIngredient2\":\"Tequila\",\n" +
            "      \"strIngredient3\":\"Triple sec\",\n" +
            "      \"strIngredient4\":\"Lemon juice\",\n" +
            "      \"strIngredient5\":\"Strawberries\",\n" +
            "      \"strIngredient6\":\"Salt\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1\\/2 oz \",\n" +
            "      \"strMeasure2\":\"1 oz \",\n" +
            "      \"strMeasure3\":\"1\\/2 oz \",\n" +
            "      \"strMeasure4\":\"1 oz \",\n" +
            "      \"strMeasure5\":\"1 oz \",\n" +
            "      \"strMeasure6\":\"\\n\",\n" +
            "      \"strMeasure7\":\"\\n\",\n" +
            "      \"strMeasure8\":\"\\n\",\n" +
            "      \"strMeasure9\":\"\\n\",\n" +
            "      \"strMeasure10\":\"\\n\",\n" +
            "      \"strMeasure11\":\"\\n\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":\"2015-08-18 14:41:51\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14554\",\n" +
            "      \"strDrink\":\"Bartender's Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Pint glass\",\n" +
            "      \"strInstructions\":\"Shake tequila, triple sec, sweet & sour, cranberry juice, and lime juice in a pint glass. Rim another pint glass with salt and transfer contents. Float the Gran Marnier, garnish with a lime and straw, and serve.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Gold tequila\",\n" +
            "      \"strIngredient2\":\"Triple sec\",\n" +
            "      \"strIngredient3\":\"Sweet and sour\",\n" +
            "      \"strIngredient4\":\"Lime\",\n" +
            "      \"strIngredient5\":\"Grand Marnier\",\n" +
            "      \"strIngredient6\":\"Cranberry juice\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 1\\/2 oz Cuervo premium or \",\n" +
            "      \"strMeasure2\":\"3\\/4 oz \",\n" +
            "      \"strMeasure3\":\"3 oz \",\n" +
            "      \"strMeasure4\":\"Juice of 1\\/2 \",\n" +
            "      \"strMeasure5\":\"Float \",\n" +
            "      \"strMeasure6\":\"Splash \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\" \",\n" +
            "      \"strMeasure11\":\" \",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"15308\",\n" +
            "      \"strDrink\":\"RumRunner's Easy Margarita\",\n" +
            "      \"strCategory\":\"Cocktail\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Pitcher\",\n" +
            "      \"strInstructions\":\"Whisk all ingredients in pitcher. Serve over ice. If frozen Margarita required, substitute ice for water and blend.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Limeade\",\n" +
            "      \"strIngredient2\":\"Tequila\",\n" +
            "      \"strIngredient3\":\"Gold tequila\",\n" +
            "      \"strIngredient4\":\"Triple sec\",\n" +
            "      \"strIngredient5\":\"Water\",\n" +
            "      \"strIngredient6\":\"Lime juice\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 can frozen \",\n" +
            "      \"strMeasure2\":\"1\\/2 can silver \",\n" +
            "      \"strMeasure3\":\"1\\/2 can \",\n" +
            "      \"strMeasure4\":\"1 1\\/2 oz \",\n" +
            "      \"strMeasure5\":\"3 1\\/3 cans iced \",\n" +
            "      \"strMeasure6\":\"1 splash fresh \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\" \",\n" +
            "      \"strMeasure11\":\" \",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"15731\",\n" +
            "      \"strDrink\":\"Hand-Shaken Margarita on the Rocks\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"use large metal container with plenty of ice and a strainer. Shake well, pour through strainer into margarita glass. Serve with salt and fresh lime.\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Gold tequila\",\n" +
            "      \"strIngredient2\":\"Sweet and sour\",\n" +
            "      \"strIngredient3\":\"Lime juice\",\n" +
            "      \"strIngredient4\":\"Triple sec\",\n" +
            "      \"strIngredient5\":\"\",\n" +
            "      \"strIngredient6\":\"\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"1 shot \",\n" +
            "      \"strMeasure2\":\"1 1\\/2 part \",\n" +
            "      \"strMeasure3\":\"1-2 tblsp \",\n" +
            "      \"strMeasure4\":\"1\\/2 oz \",\n" +
            "      \"strMeasure5\":\" \",\n" +
            "      \"strMeasure6\":\" \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\"\",\n" +
            "      \"strMeasure11\":\"\",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    },\n" +
            "    {\n" +
            "      \"idDrink\":\"14974\",\n" +
            "      \"strDrink\":\"Ken and Kirsten's top shelf Margarita\",\n" +
            "      \"strCategory\":\"Ordinary Drink\",\n" +
            "      \"strAlcoholic\":\"Alcoholic\",\n" +
            "      \"strGlass\":\"Margarita\\/Coupette glass\",\n" +
            "      \"strInstructions\":\"Mix all ingredients and add ice. Shake well pouring ingredients into a second glass. At this point coat the rim of the first glass with salt. Repour your drink into the salted glass. Add fresh squeezed lime, kick back and enjoy!\",\n" +
            "      \"strDrinkThumb\":null,\n" +
            "      \"strIngredient1\":\"Tequila\",\n" +
            "      \"strIngredient2\":\"Cointreau\",\n" +
            "      \"strIngredient3\":\"Lemonade\",\n" +
            "      \"strIngredient4\":\"Grapefruit juice\",\n" +
            "      \"strIngredient5\":\"Lime\",\n" +
            "      \"strIngredient6\":\"Salt\",\n" +
            "      \"strIngredient7\":\"\",\n" +
            "      \"strIngredient8\":\"\",\n" +
            "      \"strIngredient9\":\"\",\n" +
            "      \"strIngredient10\":\"\",\n" +
            "      \"strIngredient11\":\"\",\n" +
            "      \"strIngredient12\":\"\",\n" +
            "      \"strIngredient13\":\"\",\n" +
            "      \"strIngredient14\":\"\",\n" +
            "      \"strIngredient15\":\"\",\n" +
            "      \"strMeasure1\":\"2 shots \",\n" +
            "      \"strMeasure2\":\"1 shot \",\n" +
            "      \"strMeasure3\":\"1 cup \",\n" +
            "      \"strMeasure4\":\"1 splash \",\n" +
            "      \"strMeasure5\":\"Juice of 3 wedges \",\n" +
            "      \"strMeasure6\":\"1 handful \",\n" +
            "      \"strMeasure7\":\" \",\n" +
            "      \"strMeasure8\":\" \",\n" +
            "      \"strMeasure9\":\" \",\n" +
            "      \"strMeasure10\":\" \",\n" +
            "      \"strMeasure11\":\" \",\n" +
            "      \"strMeasure12\":\"\",\n" +
            "      \"strMeasure13\":\"\",\n" +
            "      \"strMeasure14\":\"\",\n" +
            "      \"strMeasure15\":\"\",\n" +
            "      \"dateModified\":null\n" +
            "    }\n" +
            "  ]";
}

# Design Document
This is the design document for the WordLearner Application. It will contain details about the pages, mockups, functions, data and overall architecture of the application.


## Main Pages
These are the main pages that will be displayed on the main screen of the application and will be switchable using a bottom tab.

### Home
This will essentially just be a dashboard for displaying progress

Elements:
- Language you are learning (flag with language string)
- Stats
  - Words added
    - Next to a button to add more words
  - Percentage at each level
    - A gender percentage if the language has it
  - Some stats about recent attempts
    - Success vs failure rate of answers
  - Time spent today/this week/month
  - Gamification stuff?
    - Experience
    - Achievements
    - Daily targets
    - Other

Functions:
 - Ability to change current translated language
 - Take you to add word page?

### Practice
Page leading to the primary functionality of the application, which are the practice pages.

Elements:
- Add words button
- Practice words button
- Practice gender button

Functions:
 - This will just take you each of the respective pages
 - Will hide the gender button if it doesn't exist in the language


### Words
This will allow you to navigate to various pages that will allow you to view and control the word database that the practice will be driven off. I think this part of the application should primarily be used as a way to learn words, with the subfunction to be able to edit the database as well.
  
Elements:
 - Add word button
 - Add all words button
 - Word list button

Functions:
 - This will just take you each of the respective pages



## Sub Pages
These are the pages that will navigate off the main pages. Here is where pretty much all the functionlity will be as the main pages are mostly just a display and navigation tool.

### Add Word

Elements:
 - Editable Textbox
 - Scrollbox of matching words
   - Each entry needs to contain native word, basic description and type
   - The entry is also a button
   - We need to some way to identify if a translation of this word has already been added
   - Maybe a button to play audio of word
 - Details page that will display further information about the native word along with translations
   - Word
   - Description
   - Type
   - Example usage
   - Audio
   - Selectable list of translations
     - This will just contain the word and audio button
     - Don't show words that are already added
   - Button to add
   - Button to select all
   - Button to switch language


Functions:
 - Type in word in native language
   - Return fuzzy matched list of words in database for Native language
 - Selecting native word from list will take you to a details page
 - Selectable list of translations
   - Start with nothing selected (disable the add button)
   - Select arbitrary number of translations
   - Select all button will select all words in the list
   - On Add clicked, add them to database, remove them from details page list
     - If all translations are added, immediately go back to last page
     - If not stay on this page
 - quick switch language (if you want to add the same word for other languages)

### Practice Words

Elements:
 - Word for translating at top
   - Button for playing audio
 - details about the word like description and example usage (audio button here too)
 - Answer area, which changes based on level of word
   - Word selector
   - editable textbox
     - For nouns on gendered languages, toggle buttons for definintive article
 - Complete button
 - Result display
   - For success - ???
   - For fail - ???
   - For neutral - ???

Functions:
 - alternate between showing native and foreign words to translate
 - low score words show often and are selection based (choose from X words - increase based on score)
 - medium score show less often and require typing
 - over a certain score it stops showing
 - scores decay over time
 - For nouns, provide separate definitive article buttons so they don't have to type (dependent on language)
 - add misspell check: 
  - if completely wrong, lower score
  - slightly wrong - keep score the same
  - if correct - raise score

### Practice Genders

Elements:
 - ???

Functions:
 - Simple just present the base word and request them to choose the gender
 - Should just be buttons with different genders
 - This option should not appear for non gendered languages
 - quick switch language

### Word List

Elements:
 - ???

Functions:
   - Primary view should be an easy way to learn words
   - Click on word to get more detail (including app metadata for word like level)
   - Ability for mass edit/removal
     - Should happen on long press on word
     - Icons at top to trigger - remove, reset (, complete?)
     - This simply just displays all word entries
 - Start by just show list of words in native language and can open up to see more details
 - User can then delete it, or modify it:
   - reset its score
   - delete translations
   - re-enter the add word function for this word
 - Only show translations for selected language?


### Options
 - deepl api key
 - native language
 - translation languages


## Data


### Word Entry
This represents a native word that will have a list of various translations. It should be noted that there will be repeats of native words that have different meanings (e.g. press - verb vs noun) so we will need an easy way to differentiate them both internally and to the user.

Structure:
 - id - uint64
 - word - string
 - definition - string
 - example usage - string
 - type (noun/verb/etc) - enumeration
 - Translation Entries - list/map

### Translation Entry
This represents the translation of a native word and will be stored as a list/map in the Native Entry. Again these will have repeats so we need a mechanism to make them unique both internally and to the user

Structure:
 - id - uint64
 - enabled - bool
 - word - string
 - example usage - string
 - language - string?
 - current score - int
 - audio file? - string (file reference)



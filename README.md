# Welcome Students of 4156

Please follow the assignment specifications on Courseworks when completing this project.

PMD: Static Analysis Tool 
I used PMD to help me in nalyzing and catching bugs.

Steps:

Downloaded the PMD tool from the official website.
Configured the system path to include PMD, to excute the tool from the terminal.
Run PMD: I ran the following command to analyze my project directory and generate a report:

pmd check -d /Users/rahafbinmuhanna/2025/4156/4156-Miniproject-2024-Students-Java/IndividualProject/src -R rulesets/java/quickstart.xml -f text -r pmd_report.txt

Review Report:

The file pmd_report.txt was generated with 73 lines reporting issues in the code.I reviewed and resolved these issues, documenting the process and fixes in a more detailed file, bugs.txt.

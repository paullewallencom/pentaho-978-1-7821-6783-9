Installation instructions and description of the tasks.

------------------------------------------------------------------------
1. Prerequisites.
------------------------------------------------------------------------

Below the prerequisites for the installation.
- Eclipse installed.
To know how to prepare the environment, please see the video tutorial (Section 2, Topic 1).

------------------------------------------------------------------------
2. Preparing the MyFirstInteractiveSwingApp project.
------------------------------------------------------------------------

To import the MyFirstInteractiveSwingApp project, please the tasks described below:
- Open Eclipse -> File -> Import.
- General -> Existing projects into workspace -> Next.
- Complete the 'Select archive file' with the MyFirstInteractiveSwingApp.zip file -> Finish.

The project supposes to be stored in the '/home/pentaho/workspace' folder.
If this is not the case, please execute the different tasks described below.

The first task is to update the 'my first interactive report.prpt' report and the 'my first report.prpt' report, both stored in the resources folder.
Open the report directly with the Pentaho Report Designer and update the data source connection to SampleData that should refers to the correct path (now is '/home/pentaho/workspace/MyFirstInteractiveSwingApp/...').

The second task is to update the 'projectBasePath' variable in the MyFirstInteractiveSwingApp1 and MyFirstInteractiveSwingApp2 classes.

------------------------------------------------------------------------
3. Tasks and instructions.
------------------------------------------------------------------------

As first task, please select MyFirstInteractiveSwingApp1 class from Eclipse and run the application using the green button with the white arrow in the Run menu (or press Ctrl + F11).
In few seconds you will see the report with three interactive buttons or labels.
Press the 'Action' label, the link image and the 'Button' label respectively, to see the interaction.
After testing the interaction, the report can be closed.

As second task, please select MyFirstInteractiveSwingApp2 class from Eclipse and run the application using the green button with the white arrow in the Run menu (or press Ctrl + F11).
In few seconds you will see the report with three interactive buttons or labels.
The link image and the 'Button' label interact in the same way of the first example.
Pressing the 'Action' label the 'my first report.prpt' report will be opened as secondary linked report.

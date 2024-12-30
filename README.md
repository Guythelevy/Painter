### Painter: A Shape Drawing and Manipulation Tool

Welcome to the **Painter** project! This Java application provides an intuitive interface for drawing, manipulating, and managing geometric shapes using Object-Oriented Programming (OOP) principles. The program features a graphical user interface (GUI) and supports various shape operations, including saving and loading shapes.

This project was made as the second assigment in my Intro to Java course at Ariel Universty.

## Features

- **OOP Design**: Core components are structured around reusable and extendable OOP principles.
- **Shape Types**: Supports different geometric shapes like circles, rectangles,polygons and more.
- **GUI Integration**: Provides an interactive graphical interface for shape visualization.
- **File Operations**: Save and load shape collections feature from text files.


### Explanation

- **`geo` Folder**: Contains geometric shape definitions and their implementations. All classes implement the `GeoShape` interface, ensuring a consistent API for manipulating shapes like:
  - `Circle_2D`: Represents circles.
  - `Polygon_2D`: Represents polygons.
  - `Rect_2D`: Represents rectangles.
  - `Segmant_2D`: Represents line segments.

- **`ex2` Folder**: Hosts the main application logic and related components.
  - `Ex2_main.java`: The main entry point of the application.
  - `Ex2.java`: Singleton class that handles the application lifecycle.
  - `ShapeCollection.java`: Implements the `GUI_Shape_Collection` interface, managing the collection of shapes and their interactions.

This structure ensures clear separation of concerns, making the project easy to maintain and extend.


### GUI Folder

The `gui` folder contains classes and interfaces related to the graphical representation and manipulation of shapes. These components provide the foundation for rendering shapes, handling interactions, and integrating graphical features into the application.

#### Contents:

- **`GUI_Shape.java`**:
  - This interface defines a GUI drawable shape that links a `GeoShape` object to visual attributes like color, fill status, and tag.
  - Key methods include:
    - Accessors for the shape's geometric data (`GeoShape`) and graphical attributes.
    - `copy()` for creating a deep copy of the shape.
    - `toString()` for serialization.
    - Selection state management to support GUI interactivity.

- **`GUIShape.java`**:
  - Implements the `GUI_Shape` interface.
  - Wraps a `GeoShape` with properties like color, fill status, and tag for rendering and interaction.
  - Key features:
    - **Constructors**:
      - Create shapes from geometry and visual properties.
      - Deserialize shapes from strings for save/load functionality.
    - **Supported Shapes**:
      - Handles `Circle_2D`, `Rect_2D`, `Segment_2D`, `Polygon_2D`, and `Triangle_2D`.
    - **Serialization**:
      - `toString()` generates a string representation for saving.
      - Specialized constructor parses serialized strings to reconstruct shapes.

- **`StdDraw_Ex2.java`**:
  - This class provides static methods for GUI rendering and interaction, acting as the core drawing utility.
  - Built on top of the `StdDraw` framework, it offers:
    - Methods for rendering shapes to the canvas.
    - Support for handling mouse clicks, key presses, and other user interactions.
    - Drawing utilities for custom elements, such as text, lines, and filled shapes.
  - Integration with `GUI_Shape` ensures that shapes created in the application are rendered accurately.

# TEST FILES OVERVIEW

This project includes comprehensive test files to ensure the functionality and correctness of each class and method.


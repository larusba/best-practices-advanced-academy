package exercise.refactoring_pattern.chess;

import exercise.refactoring_pattern.Color;

public class Player
{
    private String _name;
    private int _gamesWon;
    private Color _color;

    public Player(String name)
    {
        _name = name;
        _gamesWon = 0;
    }

    public String getName()
    {
        return _name;
    }

    public void increase()
    {
        _gamesWon++;
    }

    public Color getColor()
    {
        return _color;
    }

    public void setColor(Color color)
    {
        _color = color;
    }

    @Override
    public String toString()
    {
        return "NAME: " + _name + "; GAMES WON: " + _gamesWon;
    }
}

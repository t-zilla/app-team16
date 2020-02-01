import React from 'react';
import './UserTile.css';

type UserTileProps = {
    avatarImgUrl: string;
};

const UserTile = ({avatarImgUrl}: UserTileProps) => {
    return (
        <div className="user-tile"> 
            <img src={avatarImgUrl} alt="" className="user-tile__avatar"/>
        </div>
    );
};

export default UserTile;
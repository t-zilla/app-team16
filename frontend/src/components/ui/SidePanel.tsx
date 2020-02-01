import React from 'react';
import './SidePanel.css';
import UserTile from './UserTile';

const randomAvatarUrl: string = "https://i.pravatar.cc/50";

const SidePanel = () => {
    return (
        <div className="side-panel">
            <UserTile 
                avatarImgUrl={randomAvatarUrl}
            />
        </div>
    );
};

export default SidePanel;